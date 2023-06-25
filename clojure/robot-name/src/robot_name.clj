(ns robot-name)

(defn robot []
  (defn char-range [lo hi]
    range (int lo) (inc (int hi)))
  (def thing (format "%S%S%d%d%d" "R" "X" (rand-int 9) (rand-int 9) (rand-int 9)))
  )

(defn robot-name [robot] ;; <- arglist goes here
  thing
)

(defn reset-name [robot] ;; <- arglist goes here
  ;; your code goes here
)
