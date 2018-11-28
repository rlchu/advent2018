(ns advent2018.2017day2)

(defn- spl [string regex] 
  (clojure.string/split string regex))

(defn- split-input [input]
  (map #(spl % #" ") (-> input (spl #"\n"))))

(defn- remove-blanks [input]
  (filter #(> (count %) 0) input))

(defn- convert-all-to-bigint [x]
  (map bigint x))

(defn- massage-data [input]
  (->> input 
       split-input 
       (mapv remove-blanks)
       (mapv convert-all-to-bigint)))

(defn- get-maxmin-diff [data]
  (let [max (apply max data)
        min (apply min data)
        diff (- max min)]
    diff))

(defn peep [x]
  (println x) x)

(defn d2p1-2017 [input]
  (->> input 
       massage-data          ; [(5N 1N 9N 5N) (7N 5N 3N) (2N 4N 6N 8N)]]
       (map get-maxmin-diff) ; (8N 4N 6N))
       (reduce +)            ; 18N
       (int)                 ; 18
       ))

