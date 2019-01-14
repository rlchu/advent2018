(ns advent2018.day05
  (:require [advent2018.helpers :refer [parse-int]]))

(def input (slurp "inputs/day05.input"))

(def sample "dabAcCaCBAcCcaDA")

(defn- reacts? [x y]
  (and x y (not= x y)
       (= (clojure.string/upper-case x) (clojure.string/upper-case y))))

(defn- cascade-reactions [polymer]
  (reduce #(if (reacts? (peek %1) %2) (pop %1) (conj %1 %2)) [] polymer))

(defn- remove-letter-pair [letter data]
  (remove #(= (clojure.string/upper-case letter)
              (clojure.string/upper-case %)) data))

(defn- remove-lp->cascade->count [letter]
  [letter (count (cascade-reactions (remove-letter-pair letter input)))])

(time
 (->> input
      distinct
      sort
      (take 26)
      (pmap remove-lp->cascade->count)
      (sort-by (fn [[_ freq]] freq))
      first
      last
      ))

(time (distinct input))

(defn solve-01 []
  (count (cascade-reactions input)))

(time (solve-01))

