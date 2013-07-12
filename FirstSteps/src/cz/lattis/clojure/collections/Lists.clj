(ns cz.lattis.clojure.collections.Lists)


; few ways how to create list
(def items (list "one" "two" "three" "four"))
(def items (quote ("one" "two" "three" "four")))
(def items '("one" "two" "three" "four"))

; some : can be used to determinate if a collection contains a given item
(println
  (some #(= % "two") items)"\n"
  (some #(= % "grr") items)"\n" ; returns nil
  ; using a set instead of a list is more efficient and easier
  (contains? (set items) "one")"\n"
  (contains? (set items) "oge")"\n" ; returns false
)

(def more-items (conj items "zero"))
(println more-items)
;(def more-items (cons more-items "onee"))
;(println more-items)
;(println (nth more-items 4))
;(def more-items (cond more-items "twoo"))
;(println more-items)
(def less-items (remove #(= % "zero") more-items))
(println less-items)

; into : creates a new list that contains all items in two lists
(def kids-of-mike '("greg" "peter" "booby"))
(def kids-of-karol '("marcia" "jan" "cindy"))
(def brady-bunch (into kids-of-mike kids-of-karol))
(println brady-bunch)
