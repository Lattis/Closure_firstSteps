(ns FirstSteps.core
  )

(defn foo "I don't do a whole lot."
  [x]
  (println x "Hello, World!")
)

(defn multiply
    ([x]
     (* x x))
    ([x y]
     (* x y))
    ([x y z] (* x y z))
)

(defn add
  ([x y] (+ x y))
  )
(defn div [x y] (/ x y))

(defn fact
    ([n]
     (fact n 1))
    ([n acc]
     (if (<= n 1)
         acc
         (recur (dec n) (* acc n)))))
