(ns advent2018.core-test
  (:require [midje.sweet :refer :all]
            [advent2018.2017day1 :refer :all]
            [advent2018.2017day2 :refer :all]))

(def day-one-input 
  (-> "inputs/day1-2017.input" slurp clojure.string/trim-newline bigint))

(def day-two-input
  (-> "inputs/day2-2017.input" slurp))

(def day-two-input-b 
  (-> "inputs/day2-2017b.input" slurp))

(facts "about  1:"
       (fact "provided test cases pass:"
             (d1p1-2017 11)       => 2
             (d1p1-2017 1234)     => 0
             (d1p1-2017 1111)     => 4
             (d1p1-2017 1122)     => 3
             (d1p1-2017 91212129) => 9)

       (fact "part 1 challenge input passes: "
             (d1p1-2017 day-one-input) => 1175))

(facts "about  2017 Day 1 part 2:"
       (fact "provided test cases pass:"
             (d1p2-2017 1212)     => 6
             (d1p2-2017 1221)     => 0
             (d1p2-2017 123425)   => 4
             (d1p2-2017 123123)   => 12
             (d1p2-2017 12131415)  => 4)

       (fact "part 2 challenge input passes: "
             (d1p2-2017 day-one-input) => 1166))

(facts "about  2017 Day 2 part 1:"
       (fact "test case passes:"
             (d2p1-2017 day-two-input-b) => 18)
       (fact "test case passes:"
             (d2p1-2017 day-two-input)   => 43074))


