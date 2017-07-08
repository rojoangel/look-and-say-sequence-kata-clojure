(ns look-and-say.core
  (:require [look-and-say.aux :as aux]))

(defn next-n [n]
  (aux/seq->n (flatten (map #(conj [] 1 %1) (aux/n->seq n)))))
