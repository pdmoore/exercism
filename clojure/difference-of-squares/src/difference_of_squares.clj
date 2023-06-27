(ns difference-of-squares)



(defn square [N]
  (* N N))

(defn sum-of-squares [N]
  (reduce  + (map square (range (+ N 1)))))

(defn square-of-sum [N]
  (def sum (/ (* N (inc N)) 2) )
  (* sum sum))

(defn difference [N]
  (- (square-of-sum N) (sum-of-squares N)))