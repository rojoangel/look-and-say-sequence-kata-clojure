(ns look-and-say.core-test
  (:require [clojure.test :refer :all]
            [look-and-say.core :refer :all]))

(deftest test-next-n
  (testing "calling next-n for one digit returns one and the digit"
    (is (= 11 (next-n 1)))
    (is (= 19 (next-n 9)))))
