(ns difference-of-squares)

(defn difference [] ;; <- arglist goes here
  ;; your code goes here
)

(defn square [N]
  (* N N))

(defn sum-of-squares [N]
  (reduce  + (map square (range (+ N 1)))))

(defn square-of-sum [N]
  (def sum (/ (* N (inc N)) 2) )
  (* sum sum))
