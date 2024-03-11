(defproject com.adaiasmagdiel/deta "0.0.1"
  :description "A library in Clojure to use and manage Deta Base."
  :url "http://github.com/AdaiasMagdiel/deta-clojure"
  :license {:name "MIT"
            :url "https://opensource.org/license/mit"}
  :dependencies [
                 [org.clojure/clojure "1.11.1"]
                 [org.clojure/data.json "2.5.0"]
                 [clj-http "3.12.3"]]
  :repl-options {:init-ns deta.core})
