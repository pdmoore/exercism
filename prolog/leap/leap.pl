%leap(0).
leap(Year) :- 0 is mod(Year, 4), 0 =\= mod(Year, 100), true.
%leap(1996) :- true.
%leap(2000) :- true.
%leap(2400) :- true.
