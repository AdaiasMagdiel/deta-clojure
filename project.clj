(defproject com.adaiasmagdiel/deta "0.0.5"
  :description "A Clojure library designed to simplify interactions with the Deta Base and Deta Drive services. It provides a straightforward way to initialize a service connection and perform operations."
  :url "http://github.com/AdaiasMagdiel/deta-clojure"
  :license {:name "MIT"
            :url "https://opensource.org/license/mit"}
  :dependencies [
                 [org.clojure/clojure "1.11.1"]
                 [org.clojure/data.json "2.5.0"]
                 [clj-http "3.12.3"]]
  :plugins [[lein-cloverage "1.2.2"]]
  :repl-options {:init-ns deta}
  :repositories [["releases" {:url "https://clojars.org/repo"
                              :creds :gpg
                              :sign-releases true}]])
