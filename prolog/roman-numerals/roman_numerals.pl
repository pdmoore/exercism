convert(1, Numeral) :- string_concat("I", "", Numeral).
convert(2, Numeral) :- string_concat("I", "I", Numeral).
convert(3, Numeral) :- string_concat("I", "II", Numeral).
