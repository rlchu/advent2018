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

(defn- generate-grid-points [x y xl yl]
  (for [a (range x (+ x xl))
        b (range y (+ y yl))]
    [a b]))

(defn- get-overlap-frequencies [dat]
  (frequencies
   (->> dat
        (map parse-out-coord-info)
        (map #(apply generate-grid-points %))
        (apply concat)))

  (defn solve-01 [dat]
    (->> dat
         get-overlap-frequencies
         (filter (fn [[k v]] (not= 1 v)))
         count
         )))

(solve-01 dat)


