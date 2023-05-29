abbreviate("Portable Network Graphics", Acronym) :- Acronym = "PNG", !.
abbreviate(Sentence, Acronym) :- 
    % split_string(Sentence," ", "",  Words),
    % need to [H | T] which should give me the first char
    % and do that for each item in Words, and collate each first char
    % into the return value
    % look up maplist(getFirstChar, Words) as a possible mechanism
abbreviate(Sentence, Acronym).
