(ns cz.lattis.clojure.collections.Vectors)
; http://java.ociweb.com/mark/clojure/article.html#Vectors
; few ways how to create vector
(def numbers (vector "one" "two" "three" "four"))
(def number ["one" "two" "three" "four"])

; (get collection index outOfRangeValue) : return item that is on index in collection, in case
; the index is out of range return outOfRangeValue
; get is similar to (nth collection index), get returns nil and nth throws exception.
(println 
  (get numbers 3 "out of range")"\n"
  (get numbers 4 "out of range")"\n"
  (get numbers 4 nil)"\n"
  )

; operates on vectors and maps. 
(println 
  (assoc numbers 0 "zero")"\n"
  (assoc numbers 4 "zero")"\n"
  (subvec numbers 0 3)"\n"
  )

;(println
;  (peek vector)"\n"
;  (pop vector)"\n"
;)