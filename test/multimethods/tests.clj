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

; you can directly manipulate type hierarchies
(derive java.util.Date :multimethods/custom-type)

; final classes don't get in your way
(derive String :multimethods/custom-type)

; you can plug in new implementations
(defmethod dispatch-by-object java.util.HashSet
  [_]
  "This is a Specialized Custom Type")

(deftest test-dispatch-by-object
  (is
   (isa? java.util.Date :multimethods/custom-type))
  (are [res arg] (= res (dispatch-by-object arg))
       "This is a Map" (java.util.TreeMap.)
       "This is a HashMap" (java.util.HashMap.)
       "This is a Custom Type" (java.util.Date.)
       "This is a Custom Type" "foo"
       "This is a Specialized Custom Type" (java.util.HashSet.)))