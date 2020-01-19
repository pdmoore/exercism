public class Robot {

    private Orientation orientation;
    private GridPosition gridPosition;
    private final int ORIENTATION_COUNT;

    public Robot(GridPosition initialGridPosition, Orientation initialOrientation) {
        this.gridPosition = initialGridPosition;
        this.orientation = initialOrientation;
        ORIENTATION_COUNT = Orientation.values().length;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public GridPosition getGridPosition() {
        return gridPosition;
    }

    public void turnRight() {
        int nextEnumToTheRight = (orientation.ordinal() + 1) % ORIENTATION_COUNT;
        orientation = Orientation.values()[nextEnumToTheRight];
    }

    public void turnLeft() {
        int nextEnumToTheLeft = (orientation.ordinal() + ORIENTATION_COUNT - 1) % ORIENTATION_COUNT;
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
