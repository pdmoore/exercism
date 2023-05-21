ones(N, Numeral) :- N = 1, string_concat("I", "", Numeral).
ones(N, Numeral) :- N = 2, string_concat("I", "I", Numeral).
ones(N, Numeral) :- N = 3, Two = "II", string_concat("I", Two, Numeral).
convert(N, Numeral) :- ones(N, Numeral).
