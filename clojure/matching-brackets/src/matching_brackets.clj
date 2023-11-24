(ns matching-brackets)

;; check the first character of the remaining string
;; if it is a [{( then push it on a stack (LIFO)
;; if it is a ]}) then ensure it matches unmatched-brackets and pop from stack
;; otherwise once through the entire string return if stack is empty or not
;; complete string traversal and empty stack means no unmatched opening bracket
(defn check [ s unmatched-brackets ]
      (cond
            (empty? s) (empty? unmatched-brackets)
            (= (first s) \() (check (rest s) (conj unmatched-brackets \())
            (= (first s) \)) (and (= (peek unmatched-brackets) \() (check (rest s) (pop unmatched-brackets)))

            (= (first s) \[) (check (rest s) (conj unmatched-brackets \[))
            (= (first s) \]) (and (= (peek unmatched-brackets) \[) (check (rest s) (pop unmatched-brackets)))

            (= (first s) \{) (check (rest s) (conj unmatched-brackets \{))
            (= (first s) \}) (and (= (peek unmatched-brackets) \{) (check (rest s) (pop unmatched-brackets)))
            :else (check (rest s) unmatched-brackets)
            ))

(defn valid? [s]
      (check s [])
)

