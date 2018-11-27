(ns advent2018.2017day2)


(defn d2p1-2017 [input]
  (let [
        massaged-data (map bigint (-> input
                                      (clojure.string/split #"\n")
                                      first
                                      (clojure.string/split #" ")))
        maximum       (apply max massaged-data)
        minimum       (apply min massaged-data)
        difference    (- maximum minimum)] difference
    ))
