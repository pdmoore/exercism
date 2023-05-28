leap(Year) :- 0 is mod(Year, 400), !.
leap(Year) :- 0 is mod(Year, 100), !, fail.
leap(Year) :- 0 is mod(Year, 4).
