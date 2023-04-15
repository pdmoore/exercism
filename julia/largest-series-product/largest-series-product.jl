function largest_product(str, span)

    (span < 0 || span > length(str)) && throw(ArgumentError(""))
    
    largestProduct = 0
    digits = [parse(Int8, ch) for ch in str]
    for i = 1:length(digits) - span + 1
        largestProduct = max(largestProduct, prod(view(digits, i:i + span - 1)))
    end

    largestProduct
end
