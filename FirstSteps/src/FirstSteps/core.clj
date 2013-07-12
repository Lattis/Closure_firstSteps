(ns FirstSteps.core)

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

(defn hello [x](println x "muhehe"))