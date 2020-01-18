public class Robot {

    private final Orientation orientation;
    private final GridPosition gridPosition;

    public Robot(GridPosition initialGridPosition, Orientation initialOrientation) {
        this.gridPosition = initialGridPosition;
        this.orientation  = initialOrientation;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public GridPosition getGridPosition() {
        return gridPosition;
    }

    public void turnRight() {
        throw new UnsupportedOperationException();
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
