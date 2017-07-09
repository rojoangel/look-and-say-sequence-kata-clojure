(ns look-and-say.core-test
  (:require [clojure.test :refer :all]
            [look-and-say.core :refer :all]))

(deftest test-next-n
  (testing "calling next-n for one digit returns one and the digit"
    (is (= 11 (next-n 1)))
    (is (= 19 (next-n 9))))
  (testing "calling next-n for two different digits appends one in front of each one"
    (is (= 1119 (next-n 19))))
  (testing "calling next-n for two equal digits appends 2 in front of the digit"
    (is (= 21 (next-n 11))))
  (testing "values for sequence starting at 1"
    (is (= 11 (next-n 1)))
    (is (= 21 (next-n 11)))
    (is (= 1211 (next-n 21)))
    (is (= 111221 (next-n 1211)))
    (is (= 312211 (next-n 111221)))
    (is (= 13112221 (next-n 312211)))
    (is (= 1113213211 (next-n 13112221)))))
