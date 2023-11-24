(ns matching-brackets)

(defn newthing [ s stack ]
      (cond
            (empty? s) (empty? stack)
            (= (first s) \() (newthing (rest s) (conj stack \)))
            ;;(= (first string) \{) (newthing (rest string) (conj stack \}))
            ;;(= (first string) \[) (newthing (rest string) (conj stack \]))
            (= (first s) \)) (and (= (peek stack) \)) (newthing (rest s) (pop stack)))
            ;;(= (first string) \}) (and (= (peek stack) \}) (newthing (rest string) (pop stack)))
            ;;(= (first string) \]) (and (= (peek stack) \]) (newthing (rest string) (pop stack)))
            :else (newthing (rest s) stack)
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

