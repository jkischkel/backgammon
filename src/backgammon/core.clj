(ns backgammon.core
    (:use ring.util.response))

(defn app
    [req]
    {:status  200
     :headers {"Content-Type" "text/html"}
     :body    "<h1>Backgammon</h1>"
    })

