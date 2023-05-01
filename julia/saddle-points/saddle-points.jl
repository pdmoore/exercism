function saddlepoints(M)

    saddlePoints = []

    if (isempty(M)) 
        return saddlePoints
    end

    rows, cols = size(M)

    for i in 1:rows
        for j in 1:cols
            candidate = M[i, j]
            if all(candidate .>= M[i, :]) && all(candidate .<= M[:, j])
                push!(saddlePoints, (i, j))
            end
        end

    end

    saddlePoints
end
