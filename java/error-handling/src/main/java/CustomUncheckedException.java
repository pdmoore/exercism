class CustomUncheckedException extends RuntimeException {

    private final String message;

    CustomUncheckedException() {
        this.message = null;
    }

    CustomUncheckedException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
