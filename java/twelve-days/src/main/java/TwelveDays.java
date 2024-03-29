class TwelveDays {
    final static String ORDINAL[] = { "first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth", "eleventh", "twelfth" };
    final static String VERSETEXT[] = {
            "a Partridge in a Pear Tree",
            "two Turtle Doves",
            "three French Hens",
            "four Calling Birds",
            "five Gold Rings",
            "six Geese-a-Laying",
            "seven Swans-a-Swimming",
            "eight Maids-a-Milking",
            "nine Ladies Dancing",
            "ten Lords-a-Leaping",
            "eleven Pipers Piping",
            "twelve Drummers Drumming",
    };

    String verse(int verseNumber) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("On the %s day of Christmas my true love gave to me: ", ORDINAL[verseNumber - 1]));

        for (int i = verseNumber; i > 1; i--) {
            sb.append(VERSETEXT[i - 1]);
            sb.append(", ");
        }

        sb.append(String.format("%s%s", andIfNeeded(verseNumber), VERSETEXT[0]));

        sb.append(".\n");

        return sb.toString();
    }

    private String andIfNeeded(int verseNumber) {
        return (verseNumber > 1) ? "and " : "";
    }

    String verses(int startVerse, int endVerse) {
        StringBuilder sb = new StringBuilder();
        for (int i = startVerse; i <= endVerse; i++) {
            sb.append(verse(i));
            if (i < endVerse) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
    
    String sing() {
        return verses(1, 12);
    }
}
