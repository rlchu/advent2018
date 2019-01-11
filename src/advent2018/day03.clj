(ns advent2018.day03
  (:require [advent2018.helpers :refer [parse-int]]))

(def sample-input "#1 @ 1,3: 4x4
  #2 @ 3,1: 4x4
  #3 @ 5,5: 2x2")

(def input
  (-> "inputs/day03.input" slurp ))

(def dat (clojure.string/split-lines sample-input))

(defn- parse-out-coord-info [dat]
  (->> dat
       (re-seq #"\d+")
       (drop 1)
       (map parse-int)))

(defn- parse-line-num-coord-info [dat]
  (->> dat
       (map #(re-seq #"\d+" %))
       (map #(map parse-int %))))

(defn- generate-grid-points [line-num x y xl yl]
  (for [a (range x (+ x xl))
        b (range y (+ y yl))]
    [line-num [a b]]))

(defn- get-overlap-frequencies [dat]
  (frequencies
   (->> dat
        parse-line-num-coord-info
        (mapcat #(apply generate-grid-points %))
        )))

(->> dat
     parse-line-num-coord-info
     (mapcat #(apply generate-grid-points %))
     (group-by (fn [[_ x]] x))
     (filter (fn [[k v]] (not= 1 (count v))))
     )



(defn solve-01 [dat]
  (->> dat
       get-overlap-frequencies
       (filter (fn [[k v]] (not= 1 v)))
       count
       ))

(solve-01 dat)
