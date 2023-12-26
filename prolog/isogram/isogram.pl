isogram(Phrase) :- 
  string_upper(Phrase, Upper),
  string_chars(Upper, Chars),
  include(is_alpha, Chars, JustLetters),
  is_set(JustLetters).
