public class Logger {
    private StringBuilder log;

    public Logger() {
        log = new StringBuilder();
    }

    public void append(String message) {
        log.append(message);
    }

    public void appendLine(String message) {
        log.append(message).append("\n");
    }

    public String getLog() {
        return log.toString();
    }

}

