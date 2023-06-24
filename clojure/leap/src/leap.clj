(ns leap)

(defn leap-year? [year] ;; <- argslist goes here
  (= (mod year 4) 0)
)
