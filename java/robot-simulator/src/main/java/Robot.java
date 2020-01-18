import javax.print.attribute.standard.OrientationRequested;

public class Robot {

    private Orientation orientation;
    private final GridPosition gridPosition;

    public Robot(GridPosition initialGridPosition, Orientation initialOrientation) {
        this.gridPosition = initialGridPosition;
        this.orientation = initialOrientation;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public GridPosition getGridPosition() {
        return gridPosition;
    }

    public void turnRight() {
        int nextEnumToTheRight = (orientation.ordinal() + 1) % 4;
        orientation = Orientation.values()[nextEnumToTheRight];
    }

    public void turnLeft() {
        throw new UnsupportedOperationException();
    }

    public void advance() {
        throw new UnsupportedOperationException();
    }

    public void simulate(String listOfInstructions) {
        throw new UnsupportedOperationException();
    }
}
