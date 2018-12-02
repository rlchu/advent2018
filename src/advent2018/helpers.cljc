(ns advent2018.helpers)


(defn parse-int [s]
    #?(:clj  (Integer/parseInt s)
       :cljs  (js/parseInt s)))
