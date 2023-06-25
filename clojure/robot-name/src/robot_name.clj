(ns robot-name)

(defn random-char [] (char (+ (rand 26) 65)))
(defn random-digits [] (rand-int 1000))

(defn generate-name []  (format "%S%S%03d" (random-char) (random-char) (random-digits)) )

(defn robot []
  (def my-name (generate-name) )
  )

(defn robot-name [robot]
  my-name
)

(defn reset-name [robot]
  (def my-name (generate-name))
)
