(ns advent2018.core)

(defn digits [number]  
  (mapv #(Character/digit % 10) (str number)))

(defn d1p1-2017 [number] 
  (let [list-of-digits  (digits number)
        head            (first list-of-digits)
        adjusted-input  (conj list-of-digits head)]
   (->> adjusted-input
      (partition-by identity)
      (filter #(> (count %) 1))
      (map #(apply + (rest %)))
      (apply +))))



