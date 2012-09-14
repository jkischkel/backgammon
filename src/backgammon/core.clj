(ns backgammon.core
  (:use backgammon.game) 
  (:use ring.util.response)
  (:use ring.middleware.params))

(defn exec[req]
  (let [b (create-board)]
    ;(println req)
    ;(println (req :params))

    (print-board b)
    {:status  200
     :headers {"Content-Type" "text/html"}
     :body    (str b)
    })) 

(defn dump[handler]
    (fn [req]
      (println req)
      (handler req)))

(def app
    (-> exec
        (wrap-params)
        (dump)))

