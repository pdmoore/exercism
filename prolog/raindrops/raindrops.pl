convert(N, Sounds) :- 
    ModuloOf3 is mod(N, 3),
    ModuloOf5 is mod(N, 5), 
    ModuloOf7 is mod(N, 7), 
    (ModuloOf3 =:= 0 -> Pling = "Pling" ; Pling = ""),
    (ModuloOf5 =:= 0 -> Plang = "Plang" ; Plang = ""),
    (ModuloOf7 =:= 0 -> Plong = "Plong" ; Plong = ""),
    atomics_to_string([Pling, Plang, Plong], Result),
    (string_length(Result, 0) -> number_string(N, Sounds) ; Sounds = Result).
