isogram(Phrase) :- 
  normalize_space(string(Trimmed), Phrase),
  string_upper(Trimmed, Upper),
  string_chars(Upper, Chars),
  include(is_alpha, Chars, JustLetters),
  is_set(JustLetters).
