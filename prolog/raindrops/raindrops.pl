% Extract the string_concat
% Add mod(N,5) to the chain
% Add mod(N,7) to the chain
% convert(N, Sounds) :- number_string(N, Sounds).
convert(N, Sounds) :- divBy3(N) -> string_concat("Pling", "", Sounds) ; number_string(N, Sounds).
divBy3(N) :- 0 is mod(N,3).
