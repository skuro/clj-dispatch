(ns protocols.tests
  (:use clojure.test
        protocols))

;;;;;;;; setup dispatch table ;;;;;;;;;;;;
(extend-type String
  Registered
  (register [this] "A String was registered"))

; catch-all:
(extend-protocol Registered
  Object
  (register [this] "An Object was registered"))
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(deftest test-protocol-semantic
  (are [predicate expected] (= expected predicate)
       (isa? String Registered)       false
       (satisfies? Registered "foo")  true)
       (extends? Registered String)    true)

(deftest test-protocol-dispatch
  (are [input expected] (= expected (register input))
       "foo"                 "A String was registered"
       1                     "An Object was registered"
       (make-array String 1) "An Object was registered")
  (are [not-implemented] (thrown? IllegalArgumentException (register not-implemented))
       nil))

(comment

  ; throws IllegalStateException:
  (defn register
    "Let's try to shadow the protocol"
    [x]
    "Not registered as you might expect")

 )