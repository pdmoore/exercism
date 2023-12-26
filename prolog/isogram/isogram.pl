
isogram(false).
isogram(Phrase) :- 
  normalize_space(string(Trimmed), Phrase),
  string_upper(Trimmed, Upper),
  string_chars(Upper, Chars),
  is_set(Chars).
