import java.util.Arrays;

class ResistorColorDuo {

    String[] colors() {
        return new String[] {
                "black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"
        };
    }

    int value(String[] colors) {
        int firstResistor = colorCode(colors[0]);
        int secondResistor = colorCode(colors[1]);

        return firstResistor * 10 + secondResistor;
    }

    int colorCode(String color) {
        return Arrays.asList(colors()).indexOf(color);
    }
}
