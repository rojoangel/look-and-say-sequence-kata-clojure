(ns look-and-say.aux-test
  (:require [clojure.test :refer :all]
            [look-and-say.aux :refer :all]))

(deftest test-n->seq
  (testing "n to seq conversion"
    (is (= [0] (n->seq 0)))
    (is (= [1] (n->seq 1)))
    (is (= [9] (n->seq 9)))
    (is (= [1 0] (n->seq 10)))
    (is (= [9 9] (n->seq 99)))
    (is (= [1 0 0] (n->seq 100)))
    (is (= [9 9 9] (n->seq 999))))
  (testing "seq to n conversion"
    (is (= 0 (seq->n [0])))
    (is (= 1 (seq->n [1])))
    (is (= 9 (seq->n [9])))
    (is (= 10 (seq->n [1 0])))
    (is (= 99 (seq->n [9 9])))
    (is (= 100 (seq->n [1 0 0])))
    (is (= 999 (seq->n [9 9 9])))))