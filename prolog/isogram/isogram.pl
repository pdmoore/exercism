
isogram(false).
isogram(Phrase) :- 
  normalize_space(string(Trimmed), Phrase),
  IsEmpty = string_length(Trimmed, 0),
  (
      IsEmpty, true
  ).
