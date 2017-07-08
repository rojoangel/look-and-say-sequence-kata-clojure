(ns look-and-say.core
  (:require [look-and-say.aux :as aux]))

(defn next-n [n]
  (aux/seq->n (conj (aux/n->seq n) 1)))
