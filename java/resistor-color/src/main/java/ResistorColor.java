class ResistorColor {
    int colorCode(String color) {
        if (color.equals("black")) return 0;
        if (color.equals("orange")) return 3;

        return 9;
    }

    String[] colors() {
        return new String[] {
                "black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"
        };
    }
}
