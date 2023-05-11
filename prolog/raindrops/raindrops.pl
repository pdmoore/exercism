convert(N, Sounds) :- number_string(N, Sounds).
convert(N, Sounds) :- 0 is mod(N,3) -> string_concat("Pling", "", Sounds) ; number_string(N, Sounds).
PlingPlangPlong(N, Sounds) :- N = 3, string_concat("Pling", "", Sounds).
