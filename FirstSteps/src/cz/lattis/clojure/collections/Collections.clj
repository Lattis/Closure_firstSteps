(ns cz.lattis.clojure.Collections)
; http://java.ociweb.com/mark/clojure/article.html#Collections
; Collection operations
; count : return number of items in any collection
; conj : adds one or more items into a collection
; reverse : returns a sequence of items in reverse order
; map : applies a given function that takes one parameter to each item
(println (map #(+ % 3) [2 4 6])) ; => (5 7 9)
(println (map + [2 4 7] [5 6] [1 2 3 4])) ; => (8 12)
; apply : returns the result of a given function when all the items in a given collection are used as arguments
(println (apply + [2 4 6])) ; => 12

(def numbers ["one" "two" "three" "four"])
; functions that retrievs a single item from collection
(println "Functions that retrievs single item")
(println (first numbers))
(println (second numbers))
(println (last numbers))
(println (nth numbers 2))
;functions that retrievs several items from a collection
(println 
  "Function that retrievs several items from collection\n"
  (next numbers)"\n"
  (butlast numbers)"\n"
  (drop-last 2 numbers)"\n"
  (filter #(< (count %) 4) numbers)"\n"
  (nth numbers 3)"\n"  
)
; #() : anonzmous function
(println 
  (every? #(instance? String %) numbers)"\n"
  (not-every? #(instance? String %) numbers)"\n"
  (some #(instance? Number %) numbers)"\n"
  (not-any? #(instance? Number %) numbers)"\n"
  )