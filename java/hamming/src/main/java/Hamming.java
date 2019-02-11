import java.util.Optional;

public class Hamming {
    private String leftSide,rightSide;

    Hamming(String leftStrand, String rightStrand) {
        if(leftStrand.length() != rightStrand.length())
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        leftSide = leftStrand;
        rightSide = rightStrand;
    }

    int getHammingDistance() {
        int distance = 0;
        for (int i = 0; i<leftSide.length();i++) {
            if(leftSide.charAt(i) != rightSide.charAt(i))
                distance++;
        }
        return distance;
    }
}