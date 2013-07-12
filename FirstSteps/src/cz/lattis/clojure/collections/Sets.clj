(ns cz.lattis.clojure.collections.Sets)

; http://java.ociweb.com/mark/clojure/article.html#Sets

; few ways how to define set 
(def numbers (hash-set 1 2 3 4 5))
(def numbers #{1 2 3 4 5})
(def numbers (sorted-set 1 2 3 4 5))

(println
  "cotains? numbers 1 > "(contains? numbers 1)"\n"
  "cotains? numbers 6 > "(contains? numbers 6)"\n"
  "(numbers 3) >"(numbers 3)"\n"
  "(numbers 6) >"(numbers 6)"\n"
  )

(println (if (numbers 4) "number" "grr"))

; removing items fro sets

  (def more-numbers (conj numbers 7))"\n"
  (apply print more-numbers)
  (println "")
  (def less-numbers (disj more-numbers 7 5))"\n"
  (apply print less-numbers)
  
  ; TODO : difference, index, intersection, join, map-invert, project, rename, rename-keys, select and union.
  
