ones(N, Numeral) :- N = 1, string_concat("I", "", Numeral).
ones(N, Numeral) :- N = 2, string_concat("I", "I", Numeral).
convert(1, Numeral) :- ones(1, Numeral).
convert(2, Numeral) :- ones(2, Numeral).
convert(3, Numeral) :- Two = "II", string_concat("I", Two, Numeral).
