class ResistorColorDuo {
    int value(String[] colors) {
        String number = numberForColor(colors[0]) + numberForColor(colors[1]);
        return Integer.parseInt(number);
    }

    private String numberForColor(String color) {
        String number = "";
        switch (color) {
            case "black": number += 0; break;
            case "brown": number += 1; break;
            case "orange": number += 3; break;
            case "yellow": number += 4; break;
            case "green": number += 5; break;
            case "blue": number += 6; break;
            case "violet": number += 7; break;
            case "grey": number += 8; break;
        }
        return number;
    }
}
