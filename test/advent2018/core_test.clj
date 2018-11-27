(ns advent2018.core-test
  (:require [midje.sweet :refer :all]
            [advent2018.core :refer :all]))

(facts "about 'd1p1-2017' part 1:"
  (fact "provided test cases pass:"
        (d1p1-2017 11)       => 2
        (d1p1-2017 1234)     => 0
        (d1p1-2017 1111)     => 4
        (d1p1-2017 1122)     => 3
        (d1p1-2017 91212129) => 9)

  (fact "part 1 challenge input passes: "
        (d1p1-2017 (-> "inputs/day1-2017.input" slurp clojure.string/trim-newline bigint)) => 1175))

(facts "about 'd1p1-2017' part 1:"
  (fact "provided test cases pass:"
        (d1p2-2017 1212)     => 6
        (d1p2-2017 1221)     => 0
        (d1p2-2017 123425)   => 4
        (d1p2-2017 123123)   => 12
        (d1p2-2017 12131415)   => 4)

  (fact "part 1 challenge input passes: "
        (d1p2-2017 (-> "inputs/day1-2017.input" slurp clojure.string/trim-newline bigint)) => 1166))
