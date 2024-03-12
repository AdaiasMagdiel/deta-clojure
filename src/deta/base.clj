(ns deta.base
  (:require
    [clojure.string :as str]
    [clojure.data.json :as json]
    [clj-http.client :as client]))

(defn base [deta-key basename]
  (cond
    (or (nil? deta-key) (empty? deta-key)) (throw (Exception. "No project key defined"))
    (not= 2 (count (str/split deta-key #"_"))) (throw (Exception. "Bad project key provided")))

  (let [[collection _] (str/split deta-key #"_")]
    {
     :deta-key deta-key
     :base-url (str "https://database.deta.sh/v1/" collection "/" basename)
     }))

(defn put
  ([db data] (put db data nil))
  ([db data key]
   (let [data (if (map? data)
                data
                {"value" data})
         data (if key (assoc data "key" key) data)
         response (client/put (str (:base-url db) "/items")
                    {:body (json/write-str {:items [data]})
                     :content-type :json
                     :headers {"X-API-Key" (:deta-key db)}
                     :throw-exceptions false})]
     (let [json-data (json/read-str (:body response))]
       (if (and (= 207 (:status response)) (contains? json-data "processed"))
         (-> json-data
           (get "processed")
           (get "items")
           first)
         nil)))))

(defn get [db key]
  (when (or (nil? key) (empty? key))
    (throw (Exception. "No project key provided")))

  (let [response (client/get (str (:base-url db) "/items/" key)
                  	{:headers {"X-API-Key" (:deta-key db)}
                   	:throw-exceptions false})
      		status (:status response)
        json-data (json/read-str (:body response))]
    (if (= 200 status)
    		json-data
    		nil)))

(defn delete [db key]
  (when (or (nil? key) (empty? key))
    (throw (Exception. "No project key provided")))
  
  (client/delete (str (:base-url db) "/items/" key)
    {:headers {"X-API-Key" (:deta-key db)}
     :throw-exceptions false})

  nil)

(defn insert
  ([db data] (insert db data nil))
  ([db data key]
   (let [data (if (map? data)
                data
                {"value" data})
         data (if key (assoc data "key" key) data)
         response (client/post (str (:base-url db) "/items")
                    {:body (json/write-str {:item data})
                     :content-type :json
                     :headers {"X-API-Key" (:deta-key db)}
                     :throw-exceptions false})]
     (let [json-data (json/read-str (:body response))
           status (:status response)]
       (cond
         (= 201 status) json-data
         (= 409 status) (throw (Exception. (str "An item with key \"" key "\" already exists.")))
         :else nil)))))
