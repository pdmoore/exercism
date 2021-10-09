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
        return message(logLine) + " (" + logLevel(logLine) + ")";
    }
}
