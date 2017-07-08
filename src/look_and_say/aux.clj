(ns look-and-say.aux)

(defn n->seq [n]
  (if (zero? n)
    [0]
    (loop [n n
           ns nil]
      (if (pos? n)
        (let [i (mod n 10)]
          (recur (quot n 10) (conj ns i)))
        ns))))

(defn seq->n [ns]
  (reduce #(+ (* 10 %1) %2) 0 ns))
