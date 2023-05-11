convert(N, "PlingPlangPlong") :- 0 is mod(N, 3*5*7), !.
convert(N, "PlingPlang") :- 0 is mod(N, 3*5), !.
convert(N, "PlingPlong") :- 0 is mod(N, 3*7), !.
convert(N, "PlangPlong") :- 0 is mod(N, 5*7), !.
convert(N, "Pling") :- 0 is mod(N, 3), !.
convert(N, "Plang") :- 0 is mod(N, 5), !.
convert(N, "Plong") :- 0 is mod(N, 7), !.
convert(N, Sounds) :- number_string(N, Sounds).
