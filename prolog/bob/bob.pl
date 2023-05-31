hey(Sentence, Response) :- 
    string_upper(Sentence, Upper),
    IsQuestion = sub_string(Sentence, _, 1, 0, "?"),
    IsYelling = (Sentence = Upper),
    (
    IsQuestion, Response = "Sure.";
    IsYelling, Response = "Whoa, chill out!"; 
    Response = "Whatever."
    ).
