class Markdown {
    private static final String MARKDOWN_STRONG = "__(.+)__";
    private static final String MARKDOWN_EMPHASIS = "_(.+)_";
    private static final String HTML_STRONG = "<strong>$1</strong>";
    private static final String HTML_EMPHASIS = "<em>$1</em>";

    public static final String TAG_LIST_ITEM = "ul";
    public static final String TAG_LIST = "li";
    public static final String TAG_PARAGRAPH = "p";

    private boolean activeList;

    String parse(String markdown) {
        activeList = false;

        String[] lines = markdown.split("\n");

        String result = "";
        for (int i = 0; i < lines.length; i++) {
            result = processLine(result, lines[i]);
        }

        result += closeActiveList();
        result = convertModifiersToHtml(result);

        return result;
    }

    private String processLine(String resultInProgress, String line) {
        String htmlForThisLine = null;
        if (isHeader(line)) {
            resultInProgress += closeActiveList();
            activeList = false;

            htmlForThisLine = parseHeader(line);
        } else if (isList(line)) {
            resultInProgress += openActiveList();
            activeList = true;

            htmlForThisLine = parseListItem(line);
        } else {
            resultInProgress += closeActiveList();
            activeList = false;

            htmlForThisLine = parseParagraph(line);
        }

        return resultInProgress + htmlForThisLine;
    }

    private String openActiveList() {
        return activeList ? "" : openTag(TAG_LIST_ITEM);
    }

    private String closeActiveList() {
        return activeList ? closeTag(TAG_LIST_ITEM) : "";
    }

    private boolean isList(String line) {
        return line.contains("*");
    }

    private boolean isHeader(String line) {
        return line.contains("#");
    }

    private String parseHeader(String markdown) {
        int headerTagCount = (int) markdown.chars().filter(ch -> ch == '#').count();

        String markdownPastTheHeader = markdown.substring(headerTagCount + 1);
        String headerTag = "h" + Integer.toString(headerTagCount);
        return wrapWithTag(markdownPastTheHeader, headerTag);
    }

    private String parseListItem(String markdown) {
        String markdownPastTheListItem = markdown.substring(2);
        return wrapWithTag(markdownPastTheListItem, TAG_LIST);
    }

    private String parseParagraph(String markdown) {
        return wrapWithTag(markdown, TAG_PARAGRAPH);
    }

    private String convertModifiersToHtml(String markdown) {
        return markdown.replaceAll(MARKDOWN_STRONG, HTML_STRONG).replaceAll(MARKDOWN_EMPHASIS, HTML_EMPHASIS);
    }

    private String wrapWithTag(String markdown, String tag) {
        return openTag(tag) + markdown + closeTag(tag);
    }

    private String openTag(String tag) {
        return "<" + tag + ">";
    }

    private String closeTag(String tag) {
        return "</" + tag + ">";
    }
}