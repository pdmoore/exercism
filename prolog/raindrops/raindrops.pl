convert(N, Sounds) :- 
    DivBy3 is mod(N, 3),
    DivBy5 is mod(N, 5), 
    DivBy7 is mod(N, 7), 
    (DivBy3 =:= 0 -> Pling = "Pling" ; Pling = ""),
    (DivBy5 =:= 0 -> Plang = "Plang" ; Plang = ""),
    (DivBy7 =:= 0 -> Plong = "Plong" ; Plong = ""),
    atomics_to_string([Pling, Plang, Plong], Result),
    (string_length(Result, 0) -> number_string(N, Sounds) ; Sounds = Result).
