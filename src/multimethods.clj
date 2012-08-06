(ns multimethods)

(defn dispatch-fn [{:keys [version]}]
  version)

(defmulti multi-call dispatch-fn)

(defmethod multi-call :one [_]
  :one)

(defmethod multi-call :two [_]
  :two)

(defmethod multi-call :default [_]
  :default)