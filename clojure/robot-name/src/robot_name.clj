(ns robot-name)

(defn robot []
  (def name (format "RX%d%d%d" (rand-int 9) (rand-int 9) (rand-int 9)))
  )

(defn robot-name [robot] ;; <- arglist goes here
  name
)

(defn reset-name [robot] ;; <- arglist goes here
  ;; your code goes here
)
