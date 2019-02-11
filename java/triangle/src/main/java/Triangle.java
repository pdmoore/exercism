import java.util.*;

class Triangle {
    Set<Double> uniqueSides = new HashSet<>();

    Triangle(double side1, double side2, double side3) throws TriangleException {
        validateParameters(side1, side2, side3);

        uniqueSides.add(side1);
        uniqueSides.add(side2);
        uniqueSides.add(side3);
    }

    boolean isEquilateral() {
        return uniqueSides.size() == 1;
    }

    boolean isIsosceles() {
        return uniqueSides.size() == 2 || uniqueSides.size() == 1;
    }

    boolean isScalene() {
        return uniqueSides.size() == 3;
    }

    private void validateParameters(double side1, double side2, double side3) throws TriangleException {
        List<Double> sidesByLength = new ArrayList<>();
        sidesByLength.add(side1);
        sidesByLength.add(side2);
        sidesByLength.add(side3);
        Collections.sort(sidesByLength);
        if (sidesByLength.get(0) + sidesByLength.get(1) <= sidesByLength.get(2)) throw new TriangleException();
    }
}
