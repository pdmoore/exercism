%leap(0).
leap(1996) :- true.
leap(2000) :- true.
leap(2400) :- true.
leap(Year) :- Year % 4 == 0, true.
