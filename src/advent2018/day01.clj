(ns advent2018.day01
  (:require [advent2018.helpers :refer [parse-int]]))

(defn- data-clean [data]
  (->> (clojure.string/split data #"\n\+" )
       (map #(clojure.string/split % #"\n"))
       flatten
       (map parse-int)))

(defn- checkset-down-list [accset xs]
  (let [next-digit (first xs)]
    (if (accset next-digit)
    next-digit
    (recur (conj accset next-digit) (rest xs)))))

(defn solve-01 [data]
  (reduce + (data-clean data)))
 
(defn solve-02  [data]
  (checkset-down-list #{} (reductions + (cycle (data-clean data)))))

