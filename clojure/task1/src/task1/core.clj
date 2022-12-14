(ns task1.core)
(use '[clojure.string :only [ends-with?]])
;(remove #{elem} alphabet))))
;(some
;  (fn [u] (= u %))
;  (vec elem))
(defn step
  "step"
  [alphabet words]
  (reduce (fn [strings elem]
            (concat strings
                    (map #(str elem %)
                         (filter #(not (ends-with? elem %))
                                 alphabet))))
          ()
          words))

(defn stepper
  "combination of steps"
  [alphabet n]
  (reduce (fn [words nstep] (step alphabet words))
          alphabet
          (range (- n 1))))

(println (stepper ["a", "b", "c", "d"]  3))
;[\a, \b, \c, \d]

;(concat (#(drop (count %) %) words) a); TODO: интересная конструкция перезаписи листа, от которой я избавился
;(println (seq (char-array "ab")))
;(println #{"a"})
;(println (type (seq "ab")))
;(println (type "ab"))
;(println (type (set (seq "a"))))
;(println (type  #{"a"}))
;(println (vec(char-array "ab")))
;(println ["a", "b"])
;(println (type(vec(char-array "ab"))))
;(println (type ["a", "b"]))
;(println (type (nth (vec(char-array "ab")) 1)))
;(println (type (nth ["a", "b"] 1)))
;(println (vec "ab"))
;
;(println
;  (filter #(not (some (fn [u] (= u %))
;                      (vec "ab")))
;          [\a, \b, \c]))
;
;(println (remove (set (seq "a")) ["a", "b"]))
;(println (remove #{"a"} ["a", "b"]))
;(println (type (nth (stepper [ "a", "b", "c"] 3) 3)))