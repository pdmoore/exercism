class TwelveDays {
    final static String ORDINAL[] = { "first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth", "eleventh", "twelfth" };
    final static String VERSETEXT[] = {
            "a Partridge in a Pear Tree",
            "two Turtle Doves, ",
            "three French Hens, ",
            "four Calling Birds, ",
            "five Gold Rings, ",
            "six Geese-a-Laying, ",
            "seven Swans-a-Swimming, ",
            "eight Maids-a-Milking, ",
            "nine Ladies Dancing, ",
            "ten Lords-a-Leaping, ",
            "eleven Pipers Piping, ",
            "twelve Drummers Drumming, ",
    };

    String verse(int verseNumber) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("On the %s day of Christmas my true love gave to me: ", ORDINAL[verseNumber - 1]));

        for (int i = verseNumber; i > 1; i--) {
            sb.append(VERSETEXT[i - 1]);
        }

        if (verseNumber > 1) {
            sb.append("and ");
        }
        sb.append(VERSETEXT[0]);
        sb.append(".\n");
        return sb.toString();
    }

    String verses(int startVerse, int endVerse) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }
    
    String sing() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }
}
