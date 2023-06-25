(ns robot-name)

(defn robot []
  (def thing (format "%S%S%d%d%d" (char (+ (rand 26) 65)) (char (+ (rand 26) 65)) (rand-int 9) (rand-int 9) (rand-int 9)))
  )

(defn robot-name [robot] ;; <- arglist goes here
  thing
)

(defn reset-name [robot] ;; <- arglist goes here
  ;; your code goes here
)
