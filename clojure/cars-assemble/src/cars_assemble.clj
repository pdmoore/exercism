(ns cars-assemble)

(def magic-number 221.0)

(defn production-rate
  "Returns the assembly line's production rate per hour,
   taking into account its success rate"
  [speed]
  (* speed magic-number)
  )

(defn working-items
  "Calculates how many working cars are produced per minute"
  [speed]
  )
