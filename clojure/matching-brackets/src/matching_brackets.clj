(ns matching-brackets)

(defn newthing [ s brackets ]
      (cond
            (empty? s) (empty? brackets)
            (= (first s) \() (newthing (rest s) (conj brackets \())
            (= (first s) \[) (newthing (rest s) (conj brackets \[))
            (= (first s) \)) (and (= (peek brackets) \() (newthing (rest s) (pop brackets)))
            (= (first s) \]) (and (= (peek brackets) \[) (newthing (rest s) (pop brackets)))
            :else (newthing (rest s) brackets)
            ))

(defn valid? [s]
      ;;([] false)
      ;;([blank? s] true)
      (newthing s [])
      ;; traverse each character in the string
  ;; if it is a [{( then push it on a stack (LIFO)
  ;; if it is a ]}) then pop form stack and ensure it matches
  ;; if no match, empty stack then bail with false
  ;; otherwise once through the entire string return if stack is empty or not
  ;; empty stack and string traversal means no unmatched opening bracket
)

