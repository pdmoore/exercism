class Markdown {
    private static final String MARKDOWN_STRONG = "__(.+)__";
    private static final String MARKDOWN_EMPHASIS = "_(.+)_";
    private static final String HTML_STRONG = "<strong>$1</strong>";
    private static final String HTML_EMPHASIS = "<em>$1</em>";

    private boolean activeList;

    String parse(String markdown) {
        activeList = false;

        String[] lines = markdown.split("\n");

        String result = "";
        for (int i = 0; i < lines.length; i++) {
            result = processLine(result, lines[i]);
        }

        result += closeActiveList();

        return result;
    }

    private String processLine(String resultInProgress, String line) {
        String resultForThisLine = null;
        if (isHeader(line)) {
            resultForThisLine = parseHeader(line);
            resultInProgress += closeActiveList();
            activeList = false;
        } else if (isList(line)) {
            resultForThisLine = parseListItem(line);
            resultInProgress += openActiveList();
            activeList = true;
        } else {
            resultForThisLine = parseParagraph(line);
            resultInProgress += closeActiveList();
            activeList = false;
        }

        return resultInProgress + resultForThisLine;
    }

    private String openActiveList() {
        if (!activeList) {
            return "<ul>";
        }
        return "";
    }

    private String closeActiveList() {
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
        int headerTagCount = (int) markdown.chars().filter(ch -> ch == '#').count();

        return "<h" + Integer.toString(headerTagCount) + ">" + markdown.substring(headerTagCount + 1) + "</h" + Integer.toString(headerTagCount) + ">";
    }

    private String parseListItem(String markdown) {
        String markdownPastTheAsterisk = markdown.substring(2);
        String listItemHTML = parseSomeSymbols(markdownPastTheAsterisk);
        return "<li>" + listItemHTML + "</li>";
    }

    private String parseParagraph(String markdown) {
        return "<p>" + parseSomeSymbols(markdown) + "</p>";
    }

    private String parseSomeSymbols(String markdown) {
        String workingOn = markdown.replaceAll(MARKDOWN_STRONG, HTML_STRONG);
        workingOn = workingOn.replaceAll(MARKDOWN_EMPHASIS, HTML_EMPHASIS);
        return workingOn;
    }
}