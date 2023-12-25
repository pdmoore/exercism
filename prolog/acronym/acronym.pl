abbreviate(Sentence, Acronym):-
  string_upper(Sentence, Upper),
  split_string(Upper, "-_\s", "-_\s", UpperWords),
  maplist(first_letter_of, UpperWords, FirstLetters),
  atomics_to_string(FirstLetters, Acronym).

first_letter_of(String, FirstLetter):- 
  sub_string(String, 0, 1, _, FirstLetter).

