(ns robot-name)

(defn random-char [] (char (+ (rand 26) 65)))
(defn random-digit [] (rand-int 9))

(defn generate-name []  (format "%S%S%d%d%d" (random-char) (random-char) (random-digit) (random-digit) (random-digit)) )

(defn robot []
  (def my-name (generate-name) )
  )

(defn robot-name [robot]
  my-name
)

(defn reset-name [robot]
  (def my-name (generate-name))
)
