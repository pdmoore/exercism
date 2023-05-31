hey(Sentence, Response) :- 
    normalize_space(string(Trimmed), Sentence), 
    string_upper(Trimmed, Upper),
    IsQuestion = sub_string(Trimmed, _, 1, 0, "?"),
    IsYelling = (Trimmed = Upper),
    (
    Trimmed = "", Response = "Fine. Be that way!";
    IsQuestion, IsYelling, Reponse = "Calm down, I know what I'm doing!";
    IsQuestion, Response = "Sure.";
    IsYelling, Response = "Whoa, chill out!"; 
    Response = "Whatever."
    ).
