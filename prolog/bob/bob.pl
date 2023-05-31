hey(Sentence, Response) :- 
    normalize_space(string(Trimmed), Sentence), 
    string_upper(Trimmed, Upper),
    IsQuestion = sub_string(Trimmed, _, 1, 0, "?"),
    IsYelling = (Trimmed = Upper),
    (
    IsQuestion, Response = "Sure.";
    IsYelling, Response = "Whoa, chill out!"; 
    Response = "Whatever."
    ).
