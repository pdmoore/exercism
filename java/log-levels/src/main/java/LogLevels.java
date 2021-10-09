import java.util.Locale;

public class LogLevels {
    
    public static String message(String logLine) {
        return logLine.split(":")[1].trim();
    }

    public static String logLevel(String logLine) {
        return logLine.split("]")[0].substring(1).toLowerCase(Locale.ROOT);
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
