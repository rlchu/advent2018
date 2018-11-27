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

(defn d1p1-2017b [number] 
  (let [list-of-digits  (digits number)
        length          (count list-of-digits)
        extend-list     #(take (* 2 (count %)) (cycle %))
        rotate-via-drop #(drop 1 %)
        pair-with-input #(map vector list-of-digits %)
        keep-matches    #(filter (fn [[x y]] (= x y)) %)
        sum-results     #(apply + (map first %)) ]
   (->> list-of-digits
        extend-list
        rotate-via-drop
        pair-with-input
        keep-matches
        sum-results)))

(defn d1p2-2017 [number] 
  (let [list-of-digits  (digits number)
        length          (count list-of-digits)
        extend-list     #(take (* 2 (count %)) (cycle %))
        rotate-via-drop #(drop (/ length 2) %)
        pair-with-input #(map vector list-of-digits %)
        keep-matches    #(filter (fn [[x y]] (= x y)) %)
        sum-results     #(apply + (map first %)) ]
   (->> list-of-digits
        extend-list
        rotate-via-drop
        pair-with-input
        keep-matches
        sum-results)))

