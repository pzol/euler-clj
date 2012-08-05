(ns euler-clj.core-test
  (:use clojure.test
        euler-clj.core))

;;;;;;;;;;;;;;; general stuff ;;;;;;;;;;;;;;; 
(defn gcd [a b]
  "greatest common divisor of two positive integers"
  (cond 
    (= b 0) a
   :else    (recur b (mod a b))))

(defn lcm [a b]
  "least common multiplier of two positive integers"
  (/ (* a b) (gcd a b)))

(defn naturals [u] 
  "a lazy list of all natural numbers smaller than u"
  (range 1 u))

(def fib-seq
  "infinite seq of fibonaci numbers"
  (map first 
      (iterate 
        (fn [[a b]] [b (+ a b)]) [1 1])))

;;;;;;;;;;;;;;; problem 1 ;;;;;;;;;;;;;;; 
(with-test
  (defn problem-1 [u]
    (let [div35? (fn [n] (zero? (* (rem n 3) (rem n 5))))]
      (apply + (filter div35? (naturals u)))))
  (is (= 23     (problem-1 10)))
  (is (= 233168 (problem-1 1000)))
  )

;;;;;;;;;;;;;;; problem 2 ;;;;;;;;;;;;;;; 
(with-test
  (defn problem-2 []
    (apply + (filter even? (take-while #(< % 4000000) fib-seq))))
  (is (= 4613732 (problem-2))))
    
;;;;;;;;;;;;;;; problem 3 ;;;;;;;;;;;;;;; 



;;;;;;;;;;;;;;; problem 5 ;;;;;;;;;;;;;;;  
(with-test
  (defn problem-5 [u]
  "2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
  What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?"
  (reduce lcm (range 1 u))
  )
  (is (= 2520 (problem-5 10))))


(run-tests)
