(ns robot-name)


(def random-upper-char (char (+ (rand 26) 65)))

(defn robot []
  (def thing (format "%S%S%d%d%d" random-upper-char random-upper-char (rand-int 9) (rand-int 9) (rand-int 9)))
  )

(defn robot-name [robot]
  thing
)

(defn reset-name [robot]
  (def thing (format "%S%S%d%d%d" random-upper-char random-upper-char (rand-int 9) (rand-int 9) (rand-int 9)))
)
