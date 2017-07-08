(ns look-and-say.core-test
  (:require [clojure.test :refer :all]
            [look-and-say.core :refer :all]))

(deftest test-next-n
  (testing "calling next-n for one digit returns one and the digit"
    (is (= 11 (next-n 1)))
    (is (= 19 (next-n 9))))
  (testing "calling next-n for two different digits appends one in front of each one"
    (is (= 1119 (next-n 19)))))
