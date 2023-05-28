leap(Year) :- 0 is mod(Year, 400), true, !.
leap(Year) :- 0 is mod(Year, 4), 0 =\= mod(Year, 100), true.
