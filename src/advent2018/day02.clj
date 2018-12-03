(ns advent2018.day02
  (:require [advent2018.helpers :refer [parse-int]]))

(defn- checksum-n [data n]
  (let [part-data (->> data 
                       clojure.string/split-lines
                       (map sort) 
                       (map #(partition-by identity %))
                       (map (fn [x] (some #(= n (count %)) x ))))
        counted  ( ((fnil frequencies 0) part-data) true)]
    (if (nil? counted) 0 counted)))

(defn- common [x y n]
  (let [vectorized (map vector x y)
        pairs      (filter (fn [[x y]] (= x y)) vectorized)
        filtered   (filter #(= (first %)  (last %)) pairs)]
    (when (= n (- (count vectorized) (count filtered))) 
      filtered))) 

(defn solve-01 [data]
  (* (checksum-n data 2) (checksum-n data 3)))

(defn solve-02 [data] 
  (let [input (clojure.string/split-lines data)]
   (->>
    (for [x input y input] (common x y 1))
    (remove nil?)
    first
    (map first)
    (apply str))))

