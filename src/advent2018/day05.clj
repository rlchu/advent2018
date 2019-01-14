(ns advent2018.day05
  (:require [advent2018.helpers :refer [parse-int]]))

(def input (slurp "inputs/day05.input"))

(def sample "dabAcCaCBAcCcaDA")

(defn reacts? [x y]
  (and x y (not= x y)
       (= (clojure.string/upper-case x) (clojure.string/upper-case y))))

(count (reduce #(if (reacts? (peek %1) %2)
                  (pop %1)
                  (conj %1 %2))
               [] input))

