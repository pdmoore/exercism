(ns annalyns-infiltration)

(defn can-fast-attack?
  "Returns true if a fast-attack can be made, false otherwise."
  [knight-awake?]
  (= knight-awake? false)
  )

(defn can-spy?
  "Returns true if the kidnappers can be spied upon, false otherwise."
  [knight-awake? archer-awake? prisoner-awake?]
  (or 
  (or (= knight-awake? true) (= prisoner-awake? true))
  (or (= knight-awake? true) (= archer-awake? true))
  (or (= archer-awake? true) (= prisoner-awake? true))
  )
  )

(defn can-signal-prisoner?
  "Returns true if the prisoner can be signalled, false otherwise."
  [archer-awake? prisoner-awake?]
  (and 
    (= archer-awake? false)
    (= prisoner-awake? true)
    )
  )

(defn can-free-prisoner?
  "Returns true if prisoner can be freed, false otherwise."
  [knight-awake? archer-awake? prisoner-awake? dog-present?]
  (or 
  (and (= dog-present? false) (= prisoner-awake? true) (= archer-awake? false) (= knight-awake? false))
  (and (= dog-present? true) (= archer-awake? false))
  )
  )
