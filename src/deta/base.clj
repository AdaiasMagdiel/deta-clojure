(ns deta.base
  (:require
    [clojure.string :as str]
    [clojure.data.json :as json]
    [clj-http.client :as client]))

(defn base [deta-key basename]
  (cond
    (nil? deta-key) (throw (Exception. "No project key defined"))
    (empty? deta-key) (throw (Exception. "No project key defined"))
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
                     :headers {"X-API-Key" (:deta-key db)}})]
     (let [json-data (json/read-str (:body response))]
       (if (and (= 207 (:status response)) (contains? json-data "processed"))
         (-> json-data
           (get "processed")
           (get "items")
           first)
         nil)))))



