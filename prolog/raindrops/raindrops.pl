convert(N, Sounds) :- 
    (mod(N, 3) =:= 0 -> Pling = "Pling" ; Pling = ""),
    (mod(N, 5) =:= 0 -> Plang = "Plang" ; Plang = ""),
    (mod(N, 7) =:= 0 -> Plong = "Plong" ; Plong = ""),
    atomics_to_string([Pling, Plang, Plong], Result),
    (string_length(Result, 0) -> number_string(N, Sounds) ; Sounds = Result).
