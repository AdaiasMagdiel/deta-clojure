(ns deta.base-test
  (:require
    [clojure.test :refer :all]
    [deta.base :as base]))

(defn deta-key-test []
 	(let [key (System/getenv "DETA_KEY")]
  		(if (nil? key)
   			(do
    				(println "Please ensure you export the variable \"DETA_KEY\" with a valid Deta key.")
    				(System/exit 1))
   			key)))

(deftest base-test
  (testing "base can return valid information"
    (let [db (base/base "a0abcyxzxsr_aSecretValue" "items")]
      (is (contains? db :deta-key))
      (is (contains? db :base-url))
      (is (= (get db :deta-key) "a0abcyxzxsr_aSecretValue"))
      (is (= (get db :base-url) "https://database.deta.sh/v1/a0abcyxzxsr/items"))))

  (testing "base throw exception with invalid deta-key"
    (is (thrown? Exception (base/base nil "items")))
    (is (thrown? Exception (base/base "" "items")))
    (is (thrown? Exception (base/base "invalid" "items")))))

(deftest put-test
  (testing "Put can store data with map"
    (let [db (base/base (deta-key-test) "put-test-1")
          res (base/put db {:a 1 :b 2} "put-test-1.1")]
      (is (not (nil? res)))
      (is (map? res))
      (is (contains? res "a"))
      (is (contains? res "b"))))

  (testing "Put can store any type of data"
    (let [db (base/base (deta-key-test) "put-test-2")
          res-str (base/put db "hello" "put-test-2.1")
          res-bool (base/put db true "put-test-2.2")
          res-int (base/put db 42 "put-test-2.3")
          res-float (base/put db 3.14 "put-test-2.4")
          res-nil (base/put db nil "put-test-2.5")]
      (is (contains? res-str "value"))
      (is (contains? res-bool "value"))
      (is (contains? res-int "value"))
      (is (contains? res-float "value"))
      (is (contains? res-nil "value"))
      (is (= (get res-str "value") "hello"))
      (is (= (get res-bool "value") true))
      (is (= (get res-int "value") 42))
      (is (= (get res-float "value") 3.14))
      (is (= (get res-nil "value") nil))))

  (testing "Put can store data without key"
    (let [db (base/base (deta-key-test) "put-test-3")
          res (base/put db {:a 1 :b 2})]
      (is (contains? res "key"))))

  (testing "Put with key value overwrite key in data"
    (let [db (base/base (deta-key-test) "put-test-3")
          res (base/put db {:a 1 :b 2 :key "my-awesome-key"} "new-key")]
      (is (= (get res "key") "new-key")))))

(deftest get-test
  (testing "get can retrive valid data"
    (let [db (base/base (deta-key-test) "get-test-1")
          _ (base/put db {:a 1 :b 2 } "get-test-1.1")
          res (base/get db "get-test-1.1")]
      (is (= {"a" 1 "b" 2 "key" "get-test-1.1"} res))))

  (testing "get returns nil with non-existent key"
    (let [db (base/base (deta-key-test) "get-test-1")
          res (base/get db "this-key-non-exists")]
      (is (nil? res))))

  (testing "get throws exception´with non-valid key"
    (let [db (base/base (deta-key-test) "get-test-1")]
      (is (thrown? Exception (base/get db nil)))
      (is (thrown? Exception (base/get db ""))))))


(deftest delete-test
  (testing "delete can remove data"
    (let [db (base/base (deta-key-test) "delete-test-1")
          _ (base/put db {:a 1 :b 2 } "delete-test-1.1")
          _ (base/delete db "delete-test-1.1")]
      (is (nil? (base/get db "delete-test-1.1")))))  

  (testing "delete returns nil with non-existent key"
    (let [db (base/base (deta-key-test) "delete-test-2")
          res (base/delete db "this-should-be-inexistent")]
      (is (nil? res))))

  (testing "delete throws exception´with non-valid key"
    (let [db (base/base (deta-key-test) "delete-test-3")]
      (is (thrown? Exception (base/delete db nil)))
      (is (thrown? Exception (base/delete db ""))))))

(deftest insert-test
  (testing "Insert can store data with map"
    (let [db (base/base (deta-key-test) "insert-test-1")
          res (base/insert db {:a 1 :b 2} "insert-test-1.1")]
      (is (not (nil? res)))
      (is (map? res))
      (is (contains? res "a"))
      (is (contains? res "b"))))

  (testing "Insert can store any type of data"
    (let [db (base/base (deta-key-test) "insert-test-2")
          res-str (base/insert db "hello" "insert-test-2.1")
          res-bool (base/insert db true "insert-test-2.2")
          res-int (base/insert db 42 "insert-test-2.3")
          res-float (base/insert db 3.14 "insert-test-2.4")
          res-nil (base/insert db nil "insert-test-2.5")]
      (is (contains? res-str "value"))
      (is (contains? res-bool "value"))
      (is (contains? res-int "value"))
      (is (contains? res-float "value"))
      (is (contains? res-nil "value"))
      (is (= (get res-str "value") "hello"))
      (is (= (get res-bool "value") true))
      (is (= (get res-int "value") 42))
      (is (= (get res-float "value") 3.14))
      (is (= (get res-nil "value") nil))))

  (testing "Insert can store data without key"
    (let [db (base/base (deta-key-test) "insert-test-3")
          res (base/insert db {:a 1 :b 2})]
      (is (contains? res "key"))))

  (testing "Insert with key value overwrite key in data"
    (let [db (base/base (deta-key-test) "insert-test-4")
          res (base/insert db {:a 1 :b 2 :key "my-awesome-key"} "new-key")]
      (is (= (get res "key") "new-key"))))

  (testing "Insert can not insert duplicated key"
    (let [db (base/base (deta-key-test) "insert-test-5")
          _ (base/insert db {:a 1 :b 2} "key")]
      (is (thrown? Exception (base/insert db {:c 3 :d 4} "key"))))))

(defn fetch-test []
  (testing "fetch can retrieve data with valid query"
    (let [db (base/base (deta-key-test) "fetch-test-1")
          _ (base/put db {:a 1 :b 2} "fetch-test-1.1")
          res (base/fetch db {:a 1})]
      (is (not (nil? res)))
      (is (map? res))
      (is (contains? res :count))
      (is (contains? res :last))
      (is (contains? res :items))
      (is (> (:count res) 0))))

  (testing "fetch returns empty result with non-matching query"
    (let [db (base/base (deta-key-test) "fetch-test-2")
          _ (base/put db {:a 1 :b 2} "fetch-test-2.1")
          res (base/fetch db {:a 3})]
      (is (not (nil? res)))
      (is (map? res))
      (is (contains? res :count))
      (is (contains? res :last))
      (is (contains? res :items))
      (is (= (:count res) 0))))

  (testing "fetch can handle multiple queries"
    (let [db (base/base (deta-key-test) "fetch-test-4")
          _ (base/put db {:a 1 :b 2} "fetch-test-4.1")
          _ (base/put db {:a 2 :b 3} "fetch-test-4.2")
          res (base/fetch db [{:a 1} {:a 2}])]
      (is (not (nil? res)))
      (is (map? res))
      (is (contains? res :count))
      (is (contains? res :last))
      (is (contains? res :items))
      (is (> (:count res) 0))))

  (testing "fetch can handle pagination"
    (let [db (base/base (deta-key-test) "fetch-test-5")
          _ (base/put db {:a 1 :b 2} "fetch-test-5.1")
          _ (base/put db {:a 2 :b 3} "fetch-test-5.2")
          _ (base/put db {:a 3 :b 4} "fetch-test-5.3")
          res (base/fetch db {:a 1} {:limit 2})]
      (is (not (nil? res)))
      (is (map? res))
      (is (contains? res :count))
      (is (contains? res :last))
      (is (contains? res :items))
      (is (= (:count res) 2))
      (is (not (nil? (:last res))))))

  (testing "fetch can retrieve all database"
    (let [db (base/base (deta-key-test) "fetch-test-6")
          _ (base/put db {:a 1 :b 2} "fetch-test-6.1")
          _ (base/put db {:a 2 :b 3} "fetch-test-6.2")
          _ (base/put db {:a 3 :b 4} "fetch-test-6.3")
          res (base/fetch db)]
      (is (not (nil? res)))
      (is (map? res))
      (is (contains? res :count))
      (is (contains? res :last))
      (is (contains? res :items))
      (is (= (:count res) 3)))))
