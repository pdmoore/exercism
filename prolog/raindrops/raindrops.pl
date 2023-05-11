% Extract the string_concat
% Add mod(N,5) to the chain
% Add mod(N,7) to the chain
convert(N, Sounds) :- divBy3(N), divBy5(N), divBy7(N) -> string_concat("PlingPlangPlong", "", Sounds) ; number_string(N, Sounds).
convert(N, Sounds) :- divBy3(N), divBy5(N) -> string_concat("PlingPlang", "", Sounds) ; number_string(N, Sounds).
convert(N, Sounds) :- divBy3(N), divBy7(N) -> string_concat("PlingPlong", "", Sounds) ; number_string(N, Sounds).
convert(N, Sounds) :- divBy5(N), divBy7(N) -> string_concat("PlangPlong", "", Sounds) ; number_string(N, Sounds).
divBy3(N) :- 0 is mod(N,3).
divBy5(N) :- 0 is mod(N,5).
divBy7(N) :- 0 is mod(N,7).
convert(N, "Pling") :- 0 is mod(N, 3), !.
convert(N, "Plang") :- 0 is mod(N, 5), !.
convert(N, "Plong") :- 0 is mod(N, 7), !.
convert(N, Sounds) :- number_string(N, Sounds).
