(ns advent2018.core-test
  (:require [midje.sweet :refer :all]
            [advent2018.core :refer :all]))

(facts "about 'day-one-2017' part 1:"
  (fact "provided test cases pass:"
        (day-one-2017 11)       => 2
        (day-one-2017 1234)     => 0
        (day-one-2017 1111)     => 4
        (day-one-2017 1122)     => 3
        (day-one-2017 91212129) => 9)

  (fact "part 1 challenge input passes: "
        (day-one-2017 (-> "inputs/day1-2017.input" slurp clojure.string/trim-newline bigint)) => 1175))

