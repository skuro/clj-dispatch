(ns arity)

(defn sum-them
  ([x y]
     (print "arity2")
     (+ x y))
  ([x y z]
     (print "arity3")
     (+ x y z)))