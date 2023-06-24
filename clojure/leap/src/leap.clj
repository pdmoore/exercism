(ns leap)

(defn leap-year? [year] ;; <- argslist goes here
  (and
    (zero? (mod year 4))
    (or
      (not= (mod year 100) 0)
      (zero? (mod year 400))))
)
