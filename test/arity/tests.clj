(ns arity.tests
  (:use clojure.test
        arity))

(deftest test-arity-dispatch
  (are [out args] (= out (with-out-str (apply sum-them args)))
       "arity2" [1 2]
       "arity3" [1 2 3]))