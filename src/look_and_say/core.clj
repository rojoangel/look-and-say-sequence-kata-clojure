(ns look-and-say.core
  (:require [look-and-say.aux :as aux]))

(comment
  ; reduce version using conj & reverse
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
         aux/seq->n)))

(comment
  ; recursive
  (defn- next-seq [ns]
    (if (empty? ns)
      nil
      (let [equal-to-head (fn [n]
                            (= n (first ns)))
            head (take-while equal-to-head ns)
            tail (drop-while equal-to-head ns)]
        (concat [(count head) (first head)] (next-seq tail))))))

(comment
  ; loop-recur tail recursion
  (defn- next-seq [ns]
    (loop [ns ns
           acc nil]
      (if (empty? ns)
        acc
        (let [equal-to-head (fn [n]
                              (= n (first ns)))
              head (take-while equal-to-head ns)
              tail (drop-while equal-to-head ns)]
          (recur tail (concat acc [(count head) (first head)])))))))


(defn- next-seq
  ([ns]
   (next-seq ns nil))
  ([ns acc]
   (if (empty? ns)
     acc
     (let [equal-to-head (fn [n]
                           (= n (first ns)))
           head (take-while equal-to-head ns)
           tail (drop-while equal-to-head ns)]
       (recur tail (concat acc [(count head) (first head)]))))))

(defn next-n [n]
  (->> n
       aux/n->seq
       next-seq
       aux/seq->n))

(comment
  ; convoluted version - reimplemented with iterate
  (defn generate [seed length]
    (loop [acc nil
           n seed
           length length]
      (if (= 0 length)
        (reverse acc)
        (recur (conj acc n) (next-n n) (dec length))))))

(defn generate [seed length]
  (take length (iterate next-n seed)))
