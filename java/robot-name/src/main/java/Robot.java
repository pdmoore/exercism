import java.util.Random;

public class Robot {
    private String name;

    public Robot() {
    }

    public String getName() {
        if (name == null) {
            generateName();
        }

        return name;
    }

    public void reset() {
        name = null;
    }

    private void generateName() {
        name = letter() + letter() + number() + number() + number();

    }

    private String number() {
        return String.valueOf((char) (new Random().nextInt('9' - '0' + 1) + '0'));
    }

    private String letter() {
        return String.valueOf((char) (new Random().nextInt('Z' - 'A' + 1) + 'A'));
    }

}
