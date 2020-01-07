class CustomCheckedException extends Exception {

    private final String message;

    CustomCheckedException() {
        this.message = null;
    }

    CustomCheckedException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
