(ns robot-name)

(defn random-char [] (char (+ (rand 26) 65)))
(defn random-digit [] (rand-int 9))

(defn generate-name []  (format "%S%S%d%d%d" (random-char) (random-char) (random-digit) (random-digit) (random-digit)) )

(defn robot []
  (def thing (generate-name) )
  )

(defn robot-name [robot]
  thing
)

(defn reset-name [robot]
  (def thing (generate-name))
)
