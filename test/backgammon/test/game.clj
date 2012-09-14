(ns backgammon.test.game
  (:use [backgammon.game])
  (:use [clojure.test]))

(deftest board-should-have-three-areas
  (is (= 3 (count (keys (create-board))))))

(deftest stones-should-have-an-owner
  (let [name "PlayerName"]
    (is (= name (:owner (create-stone name))))))

(deftest stones-can-be-put-to-play
  (let [pos 0
        board (create-board)
        stone (create-stone "Tester")
        game (:game (put-to-play board stone pos))]
    (is (= stone (peek (nth game pos))))))

(deftest stones-can-be-put-to-home
  (let [board (create-board)
        stone (create-stone "Tester")
        home (:home (put-to-home board stone))]
    (is (= stone (peek home)))
    (is (= 1 (count home)))))

(deftest stones-can-be-put-to-bar
  (let [board (create-board)
        stone (create-stone "Tester")
        bar (:bar (put-to-bar board stone))]
      (is (= stone (peek bar)))
      (is (= 1 (count bar)))))


(comment
(deftest head-of-column-can-be-looked-up
  (let [pos 0
        stone-low (create-stone "lower")
        stone-high (create-stone "upper")
        board (put-to-play (create-board) stone-low pos)
        game (:game (put-to-play board stone-high pos))]
    (println (head-at board pos))
    (is (= stone-high (head-at board pos)))))
)
