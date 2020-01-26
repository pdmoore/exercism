class Markdown {

    String parse(String markdown) {

        String[] lines = markdown.split("\n");

        String result = "";

        boolean activeList = false;

        for (int i = 0; i < lines.length; i++) {

            String theLine = null;
            if (isHeader(lines[i])) {
                theLine = parseHeader(lines[i]);
                result += closeActiveList(activeList);
                activeList = false;
            } else if (isList(lines[i])) {
                theLine = parseListItem(lines[i]);
                result += openActiveList(activeList);
                activeList = true;
            } else {
                theLine = parseParagraph(lines[i]);

                result += closeActiveList(activeList);
                activeList = false;

            }

            result = result + theLine;
        }

        result += closeActiveList(activeList);

        return result;
    }

    private String openActiveList(boolean activeList) {
        if (!activeList) {
            return "<ul>";
        }
        return "";
    }

    private String closeActiveList(boolean activeList) {
        if (activeList) {
            return "</ul>";
        }
        return "";
    }

    private boolean isList(String line) {
        return line.contains("*");
    }

    private boolean isHeader(String line) {
        return line.contains("#");
    }

    private String parseHeader(String markdown) {
        int count = 0;

        for (int i = 0; i < markdown.length() && markdown.charAt(i) == '#'; i++) {
            count++;
        }

        if (count == 0) {
            return null;
        }

        return "<h" + Integer.toString(count) + ">" + markdown.substring(count + 1) + "</h" + Integer.toString(count) + ">";
    }

    private String parseListItem(String markdown) {
        if (markdown.startsWith("*")) {
            String skipAsterisk = markdown.substring(2);
            String listItemString = parseSomeSymbols(skipAsterisk);
            return "<li>" + listItemString + "</li>";
        }

        return null;
    }

    private String parseParagraph(String markdown) {
        return "<p>" + parseSomeSymbols(markdown) + "</p>";
    }

    private String parseSomeSymbols(String markdown) {

        String lookingFor = "__(.+)__";
        String update = "<strong>$1</strong>";
        String workingOn = markdown.replaceAll(lookingFor, update);

        lookingFor = "_(.+)_";
        update = "<em>$1</em>";
        return workingOn.replaceAll(lookingFor, update);
    }
}