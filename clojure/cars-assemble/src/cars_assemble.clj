(ns cars-assemble)

(def cars-per-hour 221)

(defn production-rate
  "Returns the assembly line's production rate per hour,
   taking into account its success rate"
  [speed]
  (def cars-produced (* speed cars-per-hour))
  (cond 
     (= speed 0)  (* cars-produced 0.0)
    (<= speed 4)  (* cars-produced 1.0)
    (<= speed 8)  (* cars-produced 0.90)
     (= speed 9)  (* cars-produced 0.80)
     (= speed 10) (* cars-produced 0.77)
    :else cars-produced)
  )

(defn working-items
  "Calculates how many working cars are produced per minute"
  [speed]
  (int (/ (production-rate speed) 60)))
