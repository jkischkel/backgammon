(defproject backgammon "0.1"
  :description "A Backgammon Game Server"
  :url "http://www.backgammon.de"
  :dependencies [[org.clojure/clojure "1.2.1"]
                 [ring/ring-core "1.0.1"]]
  :dev-dependencies [[lein-ring "0.5.4"]]
  :ring {:handler backgammon.core/app})

