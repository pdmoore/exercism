import java.util.Locale;

public class LogLevels {
    
    public static String message(String logLine) {
        int colonIndex = logLine.indexOf(':');
        return logLine.substring(colonIndex + 2).trim();
    }

    public static String logLevel(String logLine) {
        int closingBracketIndex = logLine.indexOf(']');
        return logLine.substring(1, closingBracketIndex).toLowerCase(Locale.ROOT);
    }

    public static String reformat(String logLine) {
        StringBuilder sb = new StringBuilder();
        sb.append(message(logLine));
        sb.append(" (");
        sb.append(logLevel(logLine));
        sb.append(")");
        return sb.toString();
    }
}
