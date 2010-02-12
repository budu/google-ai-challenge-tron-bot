;; Random Bot #2 =======================================================
;;
;;  by Nicolas Buduroi

(use 'map)

(defn valid?
  ([dir] (apply valid? dir (you)))
  ([dir x y]
     (not (condp = dir
            :north (wall? x (- y 1))
            :east  (wall? (+ x 1) y)
            :south (wall? x (+ y 1))
            :west  (wall? (- x 1) y)))))

(defn choose-at-random [coll]
  (let [size (count coll)]
    (when (< 0 size)
      (nth coll (rand-int size)))))

(defn next-move []
  (choose-at-random
   (filter valid? [:north :east :south :west])))

;; Game Loop ===========================================================

(defn game-loop []
  (loop []
    (initialize)
    (make-move (next-move))
    (recur)))

(game-loop)