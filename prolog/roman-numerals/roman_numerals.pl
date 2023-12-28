convert(N, Numeral) :- 
  roman(N, Digits),
  atomics_to_string(Digits, Numeral).

roman(0, []) :- !.
roman(N, ["I"  | T]) :- N < 4,   M is N - 1,   roman(M, T), !.
roman(N, ["IV" | T]) :- N < 5,   M is N - 4,   roman(M, T), !.
roman(N, ["V"  | T]) :- N < 9,   M is N - 5,   roman(M, T), !.
roman(N, ["IX" | T]) :- N < 10,  M is N - 9,   roman(M, T), !.
roman(N, ["X"  | T]) :- N < 40,  M is N - 10,  roman(M, T), !.
roman(N, ["XL" | T]) :- N < 50,  M is N - 40,  roman(M, T), !.
roman(N, ["L"  | T]) :- N < 90,  M is N - 50,  roman(M, T), !.
