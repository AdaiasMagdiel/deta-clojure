(ns deta.core-test
  (:require
    [clojure.test :refer :all]
    [deta.core :refer :all]))

(deftest base-test
  (testing "base can return valid information"
    (let [db (base "a0abcyxzxsr_aSecretValue" "items")]
      (is (contains? db :deta-key))
      (is (contains? db :base-url))
      (is (= (get db :deta-key) "a0abcyxzxsr_aSecretValue"))
      (is (= (get db :base-url) "https://database.deta.sh/v1/a0abcyxzxsr/items"))))

  (testing "base throw exception with invalid deta-key"
    (is (thrown? Exception (base nil "items")))
    (is (thrown? Exception (base "" "items")))
    (is (thrown? Exception (base "invalid" "items")))))

(deftest put-test
  (testing "Put can store data with map"
    (let [db (base "e0axfizt5ze_Xvk3SVQEzTSYLimw8TQ9YxVbHEasKrDY" "put-test-1")
          res (put db {:a 1 :b 2} "put-test-1.1")]
      (is (not (nil? res)))
      (is (map? res))
      (is (contains? res "a"))
      (is (contains? res "b"))))

  (testing "Put can store any type of data"
    (let [db (base "e0axfizt5ze_Xvk3SVQEzTSYLimw8TQ9YxVbHEasKrDY" "put-test-2")
          res-str (put db "hello" "put-test-2.1")
          res-bool (put db true "put-test-2.2")
          res-int (put db 42 "put-test-2.3")
          res-float (put db 3.14 "put-test-2.4")
          res-nil (put db nil "put-test-2.5")]
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
    (let [db (base "e0axfizt5ze_Xvk3SVQEzTSYLimw8TQ9YxVbHEasKrDY" "put-test-3")
          res (put db {:a 1 :b 2})]
      (is (contains? res "key"))))

  (testing "Put with key value overwrite key in data"
    (let [db (base "e0axfizt5ze_Xvk3SVQEzTSYLimw8TQ9YxVbHEasKrDY" "put-test-3")
          res (put db {:a 1 :b 2 :key "my-awesome-key"} "new-key")]
      (is (= (get res "key") "new-key")))))
