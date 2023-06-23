(ns log-levels
  (:require [clojure.string :as str]))

(defn message
  "Takes a string representing a log line
   and returns its message with whitespace trimmed."
  [s]
  ;;(def chop (index-of s " "))
  (def message-starts-at (+ (str/index-of s ":") 2))
  (str/trim (subs s message-starts-at))
  )

(defn log-level
  "Takes a string representing a log line
   and returns its level in lower-case."
  [s]
  (def right-bracket (str/index-of s "]"))
  (def level (subs s 1 right-bracket))
  (str/lower-case level))

(defn reformat
  "Takes a string representing a log line and formats it
   with the message first and the log level in parentheses."
  [s]
  (format "%s (%s)" (message s) (log-level s))
  )
