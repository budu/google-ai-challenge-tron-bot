;; Bot =================================================================
;;
;;  by Nicolas Buduroi

(load "map")

(defn valid-moves [x y]
  [(when-not (wall? x (- y 1)) :north)
   (when-not (wall? (+ x 1) y) :east)
   (when-not (wall? x (+ y 1)) :south)
   (when-not (wall? (- x 1) y) :west)])

(defn next-move []
  (let [moves (filter identity
                (apply valid-moves (you)))]
    (when (< 0 (count moves))
      (nth moves (rand-int (count moves))))))

(defn game-loop []
  (loop []
    (initialize)
    (make-move (next-move))
    (recur)))

(game-loop)
