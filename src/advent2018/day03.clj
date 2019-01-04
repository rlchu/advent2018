(ns advent2018.day03
  (:require [advent2018.helpers :refer [parse-int]]))


(def input 
  "#1 @ 1,3: 4x4
  #2 @ 3,1: 4x4
#3 @ 5,5: 2x2")

(def dat (clojure.string/split-lines input))

(defn parse-out-coord-info [dat]
  (->> dat 
       (re-seq #"\d+")
       (drop 1)
       (map parse-int)))

(defn generate-grid-points [x y xl yl]
  (for [a (range x (+ x xl))
        b (range y (+ y yl))]
   [a b]))

(as-> dat d
  (map parse-out-coord-info d)
  (map #(apply generate-grid-points %) d)
  (apply concat d))


(def b '([3 1] [3 2] [3 3] [3 4] [4 1] [4 2] [4 3] [4 4] [5 1] [5 2] [5 3] [5 4] [6 1] [6 2] [6 3] [6 4]))

(def a '([1 3] [1 4] [1 5] [1 6] [2 3] [2 4] [2 5] [2 6] [3 3] [3 4] [3 5] [3 6] [4 3] [4 4] [4 5] [4 6]))

(def c '([5 5] [5 6] [6 5] [6 6]))


(def d (frequencies 
       (concat a b c)))

(count (filter (fn [[k v]] (not= 1 v)) d))





