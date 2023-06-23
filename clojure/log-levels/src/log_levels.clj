(ns log-levels
  (:require [clojure.string :as str]))

(defn message
  "Takes a string representing a log line
   and returns its message with whitespace trimmed."
  [s]
  ;;(def chop (index-of s " "))
  (def message-start (+ (str/index-of s ":") 2))
  (subs s message-start)
  )

(defn log-level
  "Takes a string representing a log line
   and returns its level in lower-case."
  [s]
  )

(defn reformat
  "Takes a string representing a log line and formats it
   with the message first and the log level in parentheses."
  [s]
  )
