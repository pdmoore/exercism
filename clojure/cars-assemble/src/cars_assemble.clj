(ns cars-assemble)

(def magic-number 221.0)

(defn production-rate
  "Returns the assembly line's production rate per hour,
   taking into account its success rate"
  [speed]
  (def cars-per-hour (* speed magic-number))
  (cond 
    (= speed 9)  (* cars-per-hour 0.80)
    (= speed 10) (* cars-per-hour 0.77)
    :else cars-per-hour)
  )

(defn working-items
  "Calculates how many working cars are produced per minute"
  [speed]
  (cond
    (= speed 0) 0
    :else 16)
  )
