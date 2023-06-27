(ns difference-of-squares)

(defn difference [] ;; <- arglist goes here
  ;; your code goes here
)

(defn sum-of-squares [] ;; <- arglist goes here
  ;; your code goes here
)

(defn square-of-sum [N]
  (def sum (/ (* N (inc N)) 2) )
  (* sum sum))
