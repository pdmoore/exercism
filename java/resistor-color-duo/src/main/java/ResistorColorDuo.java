class ResistorColorDuo {
    int value(String[] colors) {
        String number = "";
        for (String color :
                colors) {

            switch (color) {
                case "black": number += 0; break;
                case "brown": number += 1; break;
                case "blue": number += 6; break;
                case "grey": number += 8; break;
            }
        }
        
        return Integer.parseInt(number);
    }
}
