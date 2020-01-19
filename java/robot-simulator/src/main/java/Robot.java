import javax.print.attribute.standard.OrientationRequested;

public class Robot {

    private Orientation orientation;
    private GridPosition gridPosition;

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
        int nextEnumToTheRight = (orientation.ordinal() + 1) % orientation.values().length;
        orientation = Orientation.values()[nextEnumToTheRight];
    }

    public void turnLeft() {
        int nextEnumToTheLeft = (orientation.ordinal() + orientation.values().length - 1) % orientation.values().length;
        orientation = Orientation.values()[nextEnumToTheLeft];
    }

    public void advance() {
        int xDelta = 0;
        int yDelta = 0;

        if (orientation == Orientation.NORTH) {
            yDelta = 1;
        } else if (orientation == Orientation.SOUTH) {
            yDelta = -1;
        } else if (orientation == Orientation.EAST) {
            xDelta = 1;
        } else if (orientation == Orientation.WEST) {
            xDelta = -1;
        }

        gridPosition = new GridPosition(gridPosition.x + xDelta, gridPosition.y + yDelta);

    }

    public void simulate(String listOfInstructions) {
        listOfInstructions.chars().forEach(c -> performInstruction((char) c));
    }

    private void performInstruction(char c) {
        switch (c) {
            case 'A' : advance(); break;
            case 'R' : turnRight(); break;
            case 'L' : turnLeft(); break;
        }
    }
}
