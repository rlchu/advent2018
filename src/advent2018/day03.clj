(ns advent2018.day03
  (:require [advent2018.helpers :refer [parse-int]]))

(def sample-input "#1 @ 1,3: 4x4
  #2 @ 3,1: 4x4
  #3 @ 5,5: 2x2")

(def input
  (-> "inputs/day03.input" slurp ))

(def dat (clojure.string/split-lines input))

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
        (mapcat #(apply generate-grid-points %))
        )))

(defn solve-01 [dat]
  (->> dat
       get-overlap-frequencies
       (filter (fn [[k v]] (not= 1 v)))
       count
       ))

 (solve-01 dat)

(defn- parse-line-num-coord-info [dat]
  (->> dat
       (map #(re-seq #"\d+" %))
       (map #(map parse-int %))))

(defn assoc-line-with-grid-points [[ln & pnts]]
  [ln (apply generate-grid-points pnts)])

(defn compare-first-shape-to-union-of-rest [[x & xs]]
  (let [line-num  (first x)
        x-set     (apply set (rest x))
        xs-set    (set (apply concat (mapcat rest xs)))]
    (clojure.set/intersection x-set xs-set)
    ))

(defn rotate [[x & xs]]
  (concat xs [x]))

(def list-of-shapes
  (->> dat
       parse-line-num-coord-info
       (map assoc-line-with-grid-points)
       ))

(defn rotate-and-check [list-of-shapes]
  ; painfully slow
  (let [rotated-list (rotate list-of-shapes)
        compare-set (compare-first-shape-to-union-of-rest rotated-list)]
    (if (empty? compare-set)
      (ffirst rotated-list)
       (recur rotated-list))))

(rotate-and-check list-of-shapes)

