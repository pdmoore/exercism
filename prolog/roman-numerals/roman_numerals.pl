ones(N, Numeral) :- N = 1, string_concat("I", "", Numeral).
ones(N, Numeral) :- N = 2, One = "I", string_concat("I", One, Numeral).
ones(N, Numeral) :- N = 3, Two = "II", string_concat("I", Two, Numeral).
ones(N, Numeral) :- N = 4, string_concat("IV", "", Numeral).


convert(N, Numeral) :- ones(N, Numeral).
