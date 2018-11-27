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

(defn d1p2-2017 [number] 
  (let [extend-list     (fn [c]
                          (take (* 2 (count c)) (cycle c)))
        
        list-of-digits  (digits number)
        length          (count list-of-digits)]
   (->> list-of-digits
       extend-list
       (drop (/ length 2))
       (map vector list-of-digits)
       (filter (fn [[x y]] (= x y)))
       (map first)
       (apply +))))


