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