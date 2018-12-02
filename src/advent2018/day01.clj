(ns advent2018.day01
  (:require [advent2018.helpers :refer [parse-int]]))

(def data
  (-> "inputs/day01.input" slurp ))

(defn- data-clean [data]
  (->> (clojure.string/split data #"\n\+" )
       (map #(clojure.string/split % #"\n"))
       flatten
       (map parse-int)))

(defn- checkset-down-list [accset xs]
  (when (seq xs)
   (let [next-digit (first xs)]
    (if (accset next-digit)
      next-digit
      (recur (conj accset next-digit) (rest xs)))) ))

(defn solve-01 [data]
  (reduce + (data-clean data)))

(defn solve-02  [data]
  (checkset-down-list #{} (reductions + (cycle (data-clean data)))))

(comment
 "an attempt to speed up solve-02 by concating the list of data 
  to itself instead of cycling one token at a time"
 (defn solve [data]
  (let [frequency-match (->> data
                             (reductions + 0)
                             (checkset-down-list #{}))] 
    (if frequency-match 
        frequency-match
        (recur (concat data data))))))
 
