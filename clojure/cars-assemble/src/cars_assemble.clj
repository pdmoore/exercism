(ns cars-assemble)

(def magic-number 221.0)

(defn production-rate
  "Returns the assembly line's production rate per hour,
   taking into account its success rate"
  [speed]
  (def cars-per-hour (* speed magic-number))
  (cond 
    (= speed 0)  (* cars-per-hour 0.0)
    (= speed 5)  (* cars-per-hour 0.90)
    (= speed 6)  (* cars-per-hour 0.90)
    (= speed 7)  (* cars-per-hour 0.90)
    (= speed 8)  (* cars-per-hour 0.90)
    (= speed 9)  (* cars-per-hour 0.80)
    (= speed 10) (* cars-per-hour 0.77)
    :else cars-per-hour)
  )

(defn working-items
  "Calculates how many working cars are produced per minute"
  [speed]
  (def rate (production-rate speed))
  (int (Math/floor
    (/ rate 60)
    ))
  )
