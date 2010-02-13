;; Wall Hugger =========================================================
;;
;;  by Nicolas Buduroi

(use 'map)

(defn north? [d] (= d :north))
(defn east? [d] (= d :east))
(defn south? [d] (= d :south))
(defn west? [d] (= d :west))

(defn countp [p coll]
  (count (filter p coll)))

(defn pos [p & ds]
  (let [[x y] p
        xp (- (countp east? ds)
              (countp west? ds))
        yp (- (countp south? ds)
              (countp north? ds))]
    [(+ x xp) (+ y yp)]))

(defn valid?
  ([dir] (apply valid? dir (you)))
  ([dir x y]
     (not (condp = dir
            :north (wall? x (dec y))
            :east  (wall? (inc x) y)
            :south (wall? x (inc y))
            :west  (wall? (dec x) y)))))

(defn adjacent [p]
  (let [[x y] p]
    [[(dec x) (dec y)] [x (dec y)] [(inc x) (dec y)]
     [(dec x) y]                   [(inc x) y]
     [(dec x) (inc y)] [x (inc y)] [(inc x) (inc y)]]))

(defn adjacent-wall? [p]
  (some wall? (adjacent p)))

(defn has-adjacent-wall? [d]
  (adjacent-wall? (pos (you) d)))

(defn next-move []
  (first
   (filter has-adjacent-wall?
     (filter valid? [:north :east :south :west]))))

;; Game Loop ===========================================================

(defn game-loop []
  (loop []
    (initialize)
    (make-move (next-move))
    (recur)))

(game-loop)
