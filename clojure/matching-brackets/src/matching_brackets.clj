(ns matching-brackets)

(defn valid?
  ([expression] false)
  ;; traverse each character in the string
  ;; if it is a [{( then push it on a stack (LIFO)
  ;; if it is a ]}) then pop form stack and ensure it matches
  ;; if no match, empty stack then bail with false
  ;; otherwise once through the entire string return if stack is empty or not
  ;; empty stack and string traversal means no unmatched opening brackets

)
