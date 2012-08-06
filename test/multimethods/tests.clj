(ns multimethods.tests
  (:use clojure.test
        multimethods))

; you can plug in new implementations in user code!
(defmethod multi-call :test [_]
  :test)

(deftest test-multimethod-dispatch
  (are [res arg] (= res (multi-call arg))
       :one {:version :one}
       :two {:version :two}
       :test {:version :test}
       :default {:version :default}
       :default {:foo :bar}))

; you can force types into  hierarchy
(derive java.util.HashSet :multimethods/custom-type)

(deftest test-dispatch-by-object
  (is
   (isa? java.util.HashSet :multimethods/custom-type))
  (are [res arg] (= res (dispatch-by-object arg))
       "This is a Map" (java.util.TreeMap.)
       "This is a HashMap" (java.util.HashMap.)
       "This is a Custom Type" (java.util.HashSet.)))