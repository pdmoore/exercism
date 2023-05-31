hey(Sentence, Response) :- string_upper(Sentence, Upper),
    Sentence = Upper,
    Response = "Whoa, chill out!", !.
hey(_, Response) :- Response = "Whatever.".
