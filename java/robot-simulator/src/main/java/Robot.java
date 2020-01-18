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
        if (Orientation.NORTH == orientation) {
            orientation = Orientation.EAST;
        } else if (Orientation.EAST == orientation) {
            orientation = Orientation.SOUTH;
        } else if (Orientation.SOUTH == orientation) {
            orientation = Orientation.WEST;
        } else if (Orientation.WEST == orientation) {
            orientation = Orientation.NORTH;
        }
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
