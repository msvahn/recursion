(ns recursion)

(defn product [coll]
  (if (empty? coll)
    1
    (* (first coll)
       (product (rest coll)))))

    (product '(1 2 4))
=   (product (cons 1 (cons 2 (cons 3 '()))))
;=> (* 1 (product (cons 2 (cons 3 '()))))
;=> (* 1 (* 2 (product (cons 3 '()))))
;=> (* 1 (* 2 (* 4 (product '()))))
;=> (* 1 (* 2 (* 4 1 )))
;=> (* 1 (* 2 4))
;=> (* 1 8)
;=> 8

(defn singleton? [coll]
  (if (empty? coll)
    false
     (if (empty? (rest coll))
       true
       false)))

(defn my-last [coll]
  (if (empty? coll)
    nil
     (if (singleton? coll)
       (first coll)
       (my-last (rest coll)))))

(defn max-element [a-seq]
  (cond
   (empty? a-seq)
   nil
   (singleton? a-seq)
    (first a-seq)
  :else
   (max (max-element (rest a-seq)))))

(defn seq-max [seq-1 seq-2]
  (if (> (count seq-1) (count seq-2))
    seq-1
    seq-2))

(defn longest-sequence [a-seq]
  (cond
   (empty? a-seq)
   nil
   (singleton? a-seq)
   (first a-seq)
   :else
   (seq-max (first a-seq) (longest-sequence (rest a-seq)))))

(defn my-filter [pred? a-seq]
  (if (empty? a-seq)
    ()
    (if (pred? (first a-seq))
       (cons (first a-seq)
       (my-filter pred? (rest a-seq)))
       (my-filter pred? (rest a-seq)))))

(defn sequence-contains? [elem a-seq]
  (cond
   (empty? a-seq)
   false
   (= elem (first a-seq))
   true
   :else
     (sequence-contains? elem (rest a-seq))))

(defn my-take-while [pred? a-seq]
  (if (empty? a-seq)
    ()
    (if (pred? (first a-seq))
    (cons (first a-seq)
          (my-take-while pred? (rest a-seq)))
    ())))

(defn my-drop-while [pred? a-seq]
  (if (empty? a-seq)
    ()
    (if (pred? (first a-seq))
    (my-drop-while pred? (rest a-seq))
     a-seq)))

(defn seq= [a-seq b-seq]
  (cond
   (and (empty? a-seq) (empty? b-seq))
   true
   (or (empty? a-seq) (empty? b-seq))
   false
   (= (first a-seq) (first b-seq))
   (seq= (rest a-seq) (rest b-seq))
   :else false))

(defn my-map [f seq-1 seq-2]
  (if (or (empty? seq-1)
          (empty? seq-2))
    ()
  (cons (f (first seq-1) (first seq-2))
        (my-map f (rest seq-1) (rest seq-2)))))

(defn power [n k]
  (if (zero? k)
    1
    (* n (power n (dec k)))))

(defn fib [n]
  (if (zero? n)
    0
    (if (= n 1)
      1
      (+ (fib (- n 1)) (fib (- n 2))))))

(defn my-repeat [how-many-times what-to-repeat]
  (if (<= how-many-times 0)
    ()
    (cons what-to-repeat (my-repeat (dec how-many-times) what-to-repeat))))

(defn my-range [up-to]
  (if (zero? up-to)
    ()
    (cons (- up-to 1) (my-range (dec up-to)))))

(defn tails [a-seq]
  (cons a-seq
        (if (empty? a-seq)
          ()
          (tails (rest a-seq)))))

(defn inits [a-seq]
  (map reverse (tails (reverse a-seq))))

(defn rotations [a-seq]
  (set(map concat (tails a-seq) (reverse(inits a-seq)))))

(defn my-frequencies-helper [freqs a-seq]
  (if (empty? a-seq)
    freqs
    (if (contains? freqs (first a-seq))
      (my-frequencies-helper
       (assoc freqs (first a-seq) (inc (get freqs (first a-seq)))) (rest a-seq))
      (my-frequencies-helper
       (assoc freqs (first a-seq) 1) (rest a-seq)))))

(defn my-frequencies [a-seq]
  (my-frequencies-helper {} a-seq))

(defn un-frequencies [a-map]
    (if (empty? a-map)
      ()
      (let [times (second (first a-map))]
      (concat (repeat times (first (first a-map)))
      (un-frequencies (rest a-map))))))

(defn my-take [n coll]
  (if (zero? n)
    ()
    (if (first coll)
      (cons (first coll)
            (my-take (dec n) (rest coll))))))

(defn my-drop [n coll]
  (if (zero? n)
    coll
    (if (first coll)
      (my-drop (dec n) (rest coll))
      ())))

(defn halve [a-seq]
  [(my-take (int (/ (count a-seq) 2)) a-seq)
  (my-drop (int (/ (count a-seq) 2)) a-seq)])

(defn seq-merge [a-seq b-seq]
  (if (empty? a-seq)
    b-seq
    (if (empty? b-seq)
      a-seq
      (if (< (first a-seq) (first b-seq))
        (cons (first a-seq) (seq-merge (rest a-seq) b-seq))
        (cons (first b-seq) (seq-merge a-seq (rest b-seq)))))))

(defn merge-sort [a-seq]
  (if (or
       (empty? a-seq)
       (singleton? a-seq))
    a-seq))

(defn merge-sort [a-seq]
  (if (or
       (empty? a-seq)
       (singleton? a-seq))
    a-seq
    (let [halfs (halve a-seq)]
    (seq-merge (merge-sort (first halfs)) (merge-sort (second halfs))))))

(defn split-into-monotonics [a-seq]
  [:-])

(defn permutations [a-set]
  [:-])

(defn powerset [a-set]
  [:-])

