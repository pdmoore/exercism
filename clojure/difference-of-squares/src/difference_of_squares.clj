(ns difference-of-squares)



(defn square [N]
  (* N N))

(defn sum-of-squares [N]
  (reduce  + (map square (range (+ N 1)))))

(defn sum [N]
  (/ (* N (inc N)) 2))

(defn square-of-sum [N]
  (* (sum N) (sum N) ))

(defn difference [N]
  (- (square-of-sum N) (sum-of-squares N)))