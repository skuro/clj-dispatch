(ns inheritance)

(defn stringify
  "Converts the input object into a String using its Java toString method"
  [x]
  (.toString x))

(defn stringify*
  "Same as stringify, but statically restricted on HashMap's to improve performance"
  [^java.util.HashMap x]
  (.toString x))