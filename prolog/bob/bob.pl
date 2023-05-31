hey(Sentence, Response) :- 
    normalize_space(string(Trimmed), Sentence), 
    IsEmpty = string_length(Trimmed, 0),
    string_upper(Trimmed, Upper),
    IsQuestion = sub_string(Trimmed, _, 1, 0, "?"),
    IsYelling = (Trimmed = Upper),
    (
    IsEmpty, Response = "Fine. Be that way!";
    IsYelling,IsQuestion, Response = "Calm down, I know what I'm doing!";
    IsQuestion, Response = "Sure.";
    IsYelling, Response = "Whoa, chill out!"; 
    Response = "Whatever."
    ).
