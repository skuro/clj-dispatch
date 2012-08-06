(ns inheritance.tests
  (:use clojure.test
        inheritance))

(deftest test-oo-inheritance
  (are [res body] (= res body)
       "{}" (stringify (java.util.HashMap.))
       "[]" (stringify (java.util.HashSet.))
       "{}" (stringify* (java.util.HashMap.))
       "{}" (stringify* (java.util.TreeMap.)))
  (is
   (thrown? ClassCastException (stringify* (java.util.HashSet.)))))