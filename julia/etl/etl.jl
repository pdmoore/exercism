function transform(input::AbstractDict)
    Dict( 
        (lowercase(letter) => score) 
        for (score, lettersWithScore) in input 
            for letter in lettersWithScore)
end

