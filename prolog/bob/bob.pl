hey(Sentence, Response) :- 
    string_upper(Sentence, Upper),
    IsYelling = (Sentence = Upper),
    (
    IsYelling, Response = "Whoa, chill out!"; 
    Response = "Whatever."
    ).
