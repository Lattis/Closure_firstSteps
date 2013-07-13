(ns cz.lattis.clojure.collections.StructMaps)

; http://java.ociweb.com/mark/clojure/article.html#StructMaps

(def vehicle-struct (create-struct :make :model :year :color))
(defstruct vehicle-struct :make :model :year :color)

(def vehicle (struct vehicle-struct "Toyota" "Prius" 2009 "blue"))
  (def make (accessor vehicle-struct :make))
(println
  (make vehicle)"\n"
  (vehicle :make)"\n"
  (:make vehicle)"\n"
)

(defrecord person [fname lname address])
(defrecord address [street city state zip])

(def stu (person. "Stu" "Halloway" 
                  (address. "200" "Durham" "NC" 27701)))

(defrecord Foo [a b])

(defrecord Bar [a b c])

(defrecord Baz [a c])

(def f (Foo. 10 20))
(println f)


(def r (map->Bar (merge f {:c 30})))
(println r)


(def z (map->Baz (merge f {:c 0})))
(println z)
