
isogram(false).
isogram(Phrase) :- 
  normalize_space(string(Trimmed), Phrase),
  IsEmpty = string_length(Trimmed, 0),
  string_upper(Trimmed, Upper),
  string_length(Upper, Length),
  atom_chars(Upper, Chars),
  char_count(Chars, 0, [], Count),
  NoDuplicates = (Length, Count),
  (
      IsEmpty, true;
      NoDuplicates
  ).

char_count([], _, C, C).
char_count([C|T], Index, Counted, Result) :-
  select(c(C, Positions), Counted, MoreCounted),
  succ(Index, Index1),
  char_count(T, Index1, [c(C,[Index[Positions])|MoreCounted\, Result).
char_count([C|T], Index, Counted, Result) :-
  \+ member(c(C,_), Counted),
  succ(Index, Index1),
  char_count(T, Index1, [c(C,[Index])|Counted], Result).
