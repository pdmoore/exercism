public class LogLevels {
    
    public static String message(String logLine) {
        int colonIndex = logLine.indexOf(':');
        return logLine.substring(colonIndex + 2).trim();
    }

    public static String logLevel(String logLine) {
        return "error";
    }

    public static String reformat(String logLine) {
        throw new UnsupportedOperationException("Please implement the (static) LogLine.reformat() method");
    }
}
