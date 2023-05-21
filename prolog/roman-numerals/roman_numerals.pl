ones(N, Numeral) :- N = 1, Numeral = "I".
ones(N, Numeral) :- N = 2, One = "I", string_concat("I", One, Numeral).
ones(N, Numeral) :- N = 3, Two = "II", string_concat("I", Two, Numeral).
ones(N, Numeral) :- N = 4, string_concat("IV", "", Numeral).
ones(N, Numeral) :- N = 5, string_concat("V", "", Numeral).
ones(N, Numeral) :- N = 6, Five = "V", One = "I", string_concat(Five, One, Numeral).


convert(N, Numeral) :- ones(N, Numeral).
