(ns advent2018.day02-test
  (:require [midje.sweet :refer :all]
            [advent2018.day02 :refer :all]))

(def input
  (-> "inputs/day02.input" slurp ))

(facts "What is the first frequency your device reaches twice?"
  (fact "input test case passes:")
   (solve-01 input) => 6916
   (solve-02 input) => "oeylbtcxjqnzhgyylfapviusr" )


