(ns protocols)

(defprotocol Registered
  (register [this] "Registers the object"))