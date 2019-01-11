(ns advent2018.day03
  (:require [advent2018.helpers :refer [parse-int]]))

(def sample-input "#1 @ 1,3: 4x4
  #2 @ 3,1: 4x4
  #3 @ 5,5: 2x2")

(def input
  (-> "inputs/day03.input" slurp ))

(def dat (clojure.string/split-lines input))

(defn- parse-line-num-coord-info [dat]
  (->> dat
       (map #(re-seq #"\d+" %))
       (map #(map parse-int %))))

(defn- generate-grid-points [line-num x y xl yl]
  (for [a (range x (+ x xl))
        b (range y (+ y yl))]
    [line-num [a b]]))

(defn solve-01 [dat] 
  (->> dat
       parse-line-num-coord-info
       (mapcat #(apply generate-grid-points %))
       (group-by (fn [[_ x]] x))
       (filter (fn [[k v]] (not= 1 (count v))))
       count
       )
  )


(defn solve-02 [dat] 
  (let [length (count (parse-line-num-coord-info dat))
        set-of-overlapped-lines (->> dat
                                     parse-line-num-coord-info
                                     (mapcat #(apply generate-grid-points %))
                                     (group-by (fn [[_ x]] x))
                                     (filter (fn [[k v]] (not= 1 (count v))))
                                     (mapcat rest)
                                     (map #(map first %))
                                     flatten
                                     set
                                     )]

    (first (clojure.set/difference
            (set (range 1 1238)) set-of-overlapped-lines))))



(solve-01 dat)

(solve-02 dat)
