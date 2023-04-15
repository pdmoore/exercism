function sum_of_multiples(limit, factors)

    uniqueFactors = Set{Int}()

    factors = filter(≠(0), factors)
    
    for factor in factors 
        nextFactor = factor
        while nextFactor < limit
            push!(uniqueFactors, nextFactor)
            nextFactor += factor
        end 
    end
    
    sum(uniqueFactors)
end
