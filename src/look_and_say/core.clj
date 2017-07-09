(ns look-and-say.core
  (:require [look-and-say.aux :as aux]))

(defn- count-me-in [acc n]
  (let [last-count (last (butlast acc))
        last-n (last acc)]
    (if (= n last-n)
      (concat (drop-last 2 acc) [(inc last-count) n])
      (concat acc [1 n]))))

(defn next-n [n]
  (->> n
       aux/n->seq
       (reduce count-me-in nil)
       aux/seq->n))
