(ns advent2018.day01-test
  (:require [midje.sweet :refer :all]
            [advent2018.day01 :refer :all]))

(def input
  (-> "inputs/day01.input" slurp ))

(facts "Starting with a frequency of zero, 
       what is the resulting frequency after 
       all of the changes in frequency have been applied?"
 (fact "input test case passes:"
   (solve-01 input) => 416))

(facts "What is the first frequency your device reaches twice?"
  (fact "input test case passes:")
   (solve-02 input) => 56752)

