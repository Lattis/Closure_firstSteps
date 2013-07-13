(ns cz.lattis.clojure.collections.Maps)

; http://java.ociweb.com/mark/clojure/article.html#Maps

; few ways how to create maps
(println "Few was how to create map :")

(def simple-map (hash-map :red :cherry, :green :apple, :purple :grape))
(def simple-map {:red :cherry, :green :apple, :purple :grape})
(def simple-map (sorted-map :red :cherry, :green :apple, :purple :grape))

(println "(def simple-map (hash-map :red :cherry, :green :apple, :purple :grape))")
(println "(def simple-map {:red :cherry, :green :apple, :purple :grape})")
(println "(def simple-map (sorted-map :red :cherry, :green :apple, :purple :grape))")

(print "--------------------------------------------------------------------------\n")
(println "How to get values from map :")
; How to get item from map ...
(println
  "(get simple-map :green) =>"(get simple-map :green)"\n"
  "(simple-map :green)     =>"(simple-map :green)"\n"
  "(:grape simple-map)     =>"(:grape simple-map)"\n"
)
(print "--------------------------------------------------------------------------\n")
(println 
" contains? : operates on sets and maps.\n"
"keys       : returns sequence of keys in given map.\n"
"vals       : returns sequence of values in given map.\n"
)
; contains? : operates on sets and maps.
; keys : returns sequence of keys in given map.
; vals : returns sequence of values in given map.
(println
  " (contains? simple-map :green) =>"(contains? simple-map :green)"\n"
  "(keys simple-map)             =>"(keys simple-map)"\n"
  "(vals simple-map)             =>"(vals simple-map)"\n"
  )
(print "--------------------------------------------------------------------------\n")
(println "assoc : operates on vectors and maps, adds new key/values pairs and replace values on existing keys\n")
; assoc : operates on vectors and maps, adds new key/values pairs and replace values on existing keys
(println
  "(assoc simple-map :green :lime :blue :berry) =>"(assoc simple-map :green :lime :blue :berry)"\n"
  )

(print "--------------------------------------------------------------------------\n")
(println "dissoc : takes map and numpber of keys. Returns map where given keys are removed.\n")
; dissoc : takes map and numpber of keys. Returns map where given keys are removed.
(println
  "(dissoc simple-map :blue :green) =>"(dissoc simple-map :blue :green)"\n"
  )

; doseq : iterates throug all the key/value pairs in simple-map and binds 
; key to color and value to flavor.
; name : returns the string name of a keyword
(doseq [[color flavor] simple-map]
  (println (str "The flavor of " (name color)
               " popsicles is " (name flavor) "."))
  )

; select-keys : takes mao and a sequence of keys, return a new map where only those keys are in map
(println 
  (select-keys simple-map [:red :green])"\n"
  )
; conj : adds all the key/value pairs from one map to another.

(def person {
             :name "Jakub"
             :surname "Lattenberk"
             :address {
                       :street "Vetrna 1056"
                       :city "Ostrava"
                       :state "CR"
                       :zip 70800
                       }
             :employer {
                        :name "TDS"
                        :address {
                                  :street "28. rijna"
                                  :city "Ostrava"
                                  :state "CR"
                                  :zip 70800          
                                  }
                        }
             })

; get-in : takes a map and a key sequence. Returns the value of the nested map key at the end of the sequence
; the -> macro and the reduse function can aslo be used for this purpose
(println 
  (get-in person [:employer :address :street])"\n"
  (-> person :employer :address :street)"\n"
  (reduce get person [:employer :address :city])
  )

; assos-in : takes map a key sequence and the new value. Returns new map where nested map key at the end of the sequence has the new value
; update-in : 
(println 
  (assoc-in person [:employer :address :city] "Clayton")"\n"
  (update-in person [:employer :address :zip]  str "-1234")
  )