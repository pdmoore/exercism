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
        int nextEnumToTheRight = (orientation.ordinal() + 1) % 4;
        orientation = Orientation.values()[nextEnumToTheRight];
    }

    public void turnLeft() {
        int nextEnumToTheLeft = (orientation.ordinal() + 3) % 4;
        orientation = Orientation.values()[nextEnumToTheLeft];
    }

    public void advance() {
        if (orientation == Orientation.NORTH) {
            gridPosition = new GridPosition(gridPosition.x, gridPosition.y + 1);
        } else if (orientation == Orientation.SOUTH) {
            gridPosition = new GridPosition(gridPosition.x, gridPosition.y - 1);
        } else if (orientation == Orientation.EAST) {
            gridPosition = new GridPosition(gridPosition.x + 1, gridPosition.y);
        } else if (orientation == Orientation.WEST) {
            gridPosition = new GridPosition(gridPosition.x - 1, gridPosition.y);
        }

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
