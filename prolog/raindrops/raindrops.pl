% Extract the string_concat
% Add mod(N,5) to the chain
% Add mod(N,7) to the chain
% convert(N, Sounds) :- number_string(N, Sounds).
convert(N, Sounds) :- divBy3(N), divBy5(N) -> string_concat("PlingPlang", "", Sounds) ; number_string(N, Sounds).
convert(N, Sounds) :- divBy3(N), divBy7(N) -> string_concat("PlingPlong", "", Sounds) ; number_string(N, Sounds).
convert(N, Sounds) :- divBy5(N), divBy7(N) -> string_concat("PlangPlong", "", Sounds) ; number_string(N, Sounds).
convert(N, Sounds) :- divBy3(N) -> string_concat("Pling", "", Sounds) ; number_string(N, Sounds).
convert(N, Sounds) :- divBy5(N) -> string_concat("Plang", "", Sounds) ; number_string(N, Sounds).
convert(N, Sounds) :- divBy7(N) -> string_concat("Plong", "", Sounds) ; number_string(N, Sounds).
divBy3(N) :- 0 is mod(N,3).
divBy5(N) :- 0 is mod(N,5).
divBy7(N) :- 0 is mod(N,7).
