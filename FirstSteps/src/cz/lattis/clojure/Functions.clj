(ns cz.lattis.clojure.Functions)

;; declare special form takes any number of function names and creates forward declarations
(declare parting) 

;; Functions defined with defn- macro are private.
;; The result of the last expression in the body is returned
(defn parting
  "Documentation info"
  [arg]
  (str "Hello, " arg))

(println (parting "Lattis"))

;; Functions can take a variable number of parameters. Opional parameters must appear at the end
;; 
(defn power [base & exponents]
  (reduce #(Math/pow %1 %2) base exponents))
(println (power 2 2 2 2))

(defn parting-lng
  ([] (parting-lng "World"))
  ([name] (parting-lng name "en"))
  ([name language]
    ;; condp : similar to switch
    (condp = language
      "en" (str "Goodbye, " name)
      "cz" (str "Nashledanou, " name)
      (throw (IllegalArgumentException. (str "Unsupported language '" language "'")))
     )
   )
)

(println
  (parting-lng)"\n"
  (parting-lng "Lattis")"\n"
  (parting-lng "Lattis" "cz")"\n"
  (parting-lng "Lattis" "en")"\n"
  ;(parting-lng "Lattis" "cc")"\n"
  )

(def years [1940 1944 1961 1985 1987])
(println (filter (fn [year] (even? year)) years))
(println (filter #(> % 1961) years))

(defn pair-test [test-fn n1 n2]
  (if (test-fn n1 n2) (str "pass") (str "fail")))

(println (pair-test #(even? (+ %1 %2)) 3 5))

(defmulti what-am-i class)
(defmethod what-am-i Number [arg] (println "This is number"))
(defmethod what-am-i String [arg] (println "This is String"))
(defmethod what-am-i :default [arg] (println "This is smth else"))
(defmulti test-f (fn [arg] arg))
(defmethod test-f 3 [arg] (println "hello"))
(defmethod test-f 5 [arg] (println "Goodbye"))

(what-am-i 1)
(what-am-i "ahoj")
(what-am-i true)
(test-f 3)
(test-f 5)

(defn callback1 [n1 n2 n3] (+ n1 n2 n3))
(defn callback2 [n1 _ n3] (+ n1 n3))
(defn caller [callback value]
  (callback (+ value 1) (+ value 2) (+ value 3)))
(println (caller callback1 10))
(println (caller callback2 10))

(defn teenager? [age] (and (>= age 13) (< age 20)))
(def non-teen? (complement teenager?))

(println (non-teen? 23))
(println (non-teen? 15))
(println (teenager? 23))
(println (teenager? 15))

(defn times2 [n] (* 2 n))
(defn minus3 [n] (- n 3))
(def composition (comp minus3 times2))
(println (composition 4))