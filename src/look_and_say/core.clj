(ns look-and-say.core
  (:require [look-and-say.aux :as aux]))

(defn- count-me-in [acc n]
  (let [last-count (last (butlast acc))
        last-n (last acc)]
    (if (= n last-n)
      (conj (drop 1 acc) (inc last-count))
      (concat acc [1 n]))))

(defn next-n [n]
  (aux/seq->n (reduce count-me-in nil (aux/n->seq n))))
