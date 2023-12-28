roman_char("V", 5).
roman_char("IV", 4).
roman_char("I", 1).

roman(0) --> "".
roman(N) --> { roman_char(Roman, Value), N >= Value }, Roman, { N1 is N - Value }, roman(N1).

convert(N, Numeral) :- 
    phrase(roman(N), Numerals), 
    string_chars(Numerals, Chars),
    atomic_list_concat(Chars, Atom),
    atom_string(Atom, Numeral), !.
