(ns aot
  (:gen-class))

(defn -main [& args]
  (dorun
   (map println (seq args))))