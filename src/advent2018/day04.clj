(ns advent2018.day04
  (:require [advent2018.helpers :refer [parse-int]]))

(def records
  (slurp "inputs/day04.input"))

(defn parse-out-numbers [dat]
  (mapv parse-int (re-seq #"\d+" dat)))

(def dat (->> records
              clojure.string/split-lines
              sort
              (map parse-out-numbers)))

(defn- parse-data [db dat]
  (if (= 6 (count dat))
    (assoc db :on-duty (last dat))
    (update-in db [(:on-duty db)] conj (last dat))))

(def parsed-data
  (dissoc (reduce parse-data {:on-duty 0} dat) :on-duty))

(defn- total-sleep [[k ranges]]
  [k (apply + (map #(apply - %) (partition 2 ranges)))])

(defn solve-01 []
  (let [sleepiest-guard  (->> parsed-data
                              (map total-sleep)
                              (sort-by (fn [[_ v]] v))
                              last
                              first)
        sleepiest-minute (->> (get-in parsed-data [sleepiest-guard])
                              (partition 2)
                              (map reverse)
                              (map #(apply range %))
                              flatten
                              frequencies
                              (sort-by (fn [[_ v]] v))
                              last
                              first)]
    (* sleepiest-guard sleepiest-minute)))

(defn get-sleepiest-minute-and-freq [id]
  (->> (get-in parsed-data [id])
       (partition 2)
       (map reverse)
       (map #(apply range %))
       flatten
       frequencies
       (sort-by (fn [[_ v]] v))
       last))

(defn solve-02 []
  (let [ids (keys parsed-data)]
    (->> ids
         (map get-sleepiest-minute-and-freq)
         (zipmap ids)
         (sort-by (fn [[_ [_ freq]]] freq))
         last
         ((fn [[id [min _]]] (* id min))))))


(time (solve-01))

(time (solve-02))
