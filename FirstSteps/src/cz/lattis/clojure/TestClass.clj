(ns cz.lattis.clojure.TestClass)

;
; definnition of global variables
;
(def ^:dynamic _name "jakub")
(def ^:dynamic _surname "lattenberk")
(def ^:dynamic v 0)

(defn print-whole-name []
  (println _name _surname))

(defn print-v [] (println "Value of v:" v))

(defn local-binding-example [] 
  (println "f2: before 'let' v:" v)
  ; (let [var value]) does not change its originally declared value, the value of v in print-v
  ; is 0 not -1
  (let [v -1] 
    ; local binding only within let statement
    (println "f2: in 'let', v:" v)
    (print-v)
    )
  (println "f2: outside 'let', v:" v)
)

(defn global-binging-example[]
  "doc"
  (println "f3: before binding, v:" v)
  ; same global binding with new, temporary value
  (binding [v 3]
    ;global binding, new value
    (println "f3: within binding function, v:" v)
    (print-v) ; calling print-v with new value
    )
  (println "f3: after binding, v:" v)
)

(defn change-global-value [] (def v 4)(print-v))

(println "(= v 1) => " (= v 1))
(println "Calling f2: ")
(local-binding-example)
(println)
(println "Calling f3: ")
(global-binging-example)
(println)
(println "Calling f4: ")
(change-global-value)
(println "after calling f4, v =" v)