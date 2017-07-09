(ns look-and-say.core
  (:require [look-and-say.aux :as aux]))

(defn- count-me-in [acc n]
  (let [last-count (second acc)
        last-n (first acc)]
    (if (= n last-n)
      (conj (drop 2 acc) (inc last-count) n)
      (conj acc 1 n))))

(defn next-n [n]
  (->> n
       aux/n->seq
       (reduce count-me-in nil)
       reverse
       aux/seq->n))

(defn generate [seed length]
  (loop [acc nil
         n seed
         length length]
    (if (= 0 length)
      (reverse acc)
      (recur (conj acc n) (next-n n) (dec length)))))