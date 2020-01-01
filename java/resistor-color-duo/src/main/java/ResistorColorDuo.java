class ResistorColorDuo {
    int value(String[] colors) {
        String number = "";
        for (String color :
                colors) {

            if ("brown".equals(color)) {
                number += "1";
            }

            if ("black".equals(color)) {
                number += "0";
            }

            if ("blue".equals(color)) {
                number += "6";
            }

            if ("grey".equals(color)) {
                number += "8";
            }
        }

        
        return Integer.parseInt(number);
    }
}
