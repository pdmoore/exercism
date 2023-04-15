function wordcount(sentence)

    countOfEachWord = Dict{String, Int64}()

    words = sentence |>
        lowercase |>
        t -> replace(t, r"(?!\b'\b)[^\w ]" => " ") |>
        t -> split(t, " ") |>
        f -> filter(!isempty, f)

    
    for word in words 
        countOfEachWord[word] = get(countOfEachWord, word, 0) + 1
    end
        
  countOfEachWord
end
