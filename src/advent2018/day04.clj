(ns advent2018.day04
  (:require [advent2018.helpers :refer [parse-int]]))

(def realsample
  (slurp "inputs/day04.input"))

(defn parse-out-numbers [dat]
  (mapv parse-int (re-seq #"\d+" dat)))

(def dat (->> realsample
              clojure.string/split-lines
              sort
              (map parse-out-numbers)))

(defn- parse-data [db dat]
  (if (= 6 (count dat))
    (assoc db :on-duty (last dat))
    (update-in db [(:on-duty db)] conj (last dat))))

(defn- parsed-data []
  (dissoc (reduce parse-data {:on-duty 0} dat) :on-duty))

(defn- total-sleep [[k ranges]]
  [k (apply + (map #(apply - %) (partition 2 ranges)))])

(defn solve-01 []
  (let [sleepiest-guard  (->> (parsed-data)
                              (map total-sleep)
                              (sort-by (fn [[_ v]] v))
                              last
                              first)
        sleepiest-minute (->> (get-in (parsed-data) [sleepiest-guard])
                              (partition 2)
                              (map reverse)
                              (map #(apply range %))
                              flatten
                              frequencies
                              (sort-by (fn [[_ v]] v))
                              last
                              first)]
    (* sleepiest-guard sleepiest-minute)))

(solve-01)

