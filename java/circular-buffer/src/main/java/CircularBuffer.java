class CircularBuffer<T> {

    private T data;

    CircularBuffer(final int size) {

    }

    T read() throws BufferIOException {
        if (data == null) {
            throw new BufferIOException("Tried to read from empty buffer");
        }

        T returnVal = data;
        data = null;
        return returnVal;
    }

    void write(T data) throws BufferIOException {
        this.data = data;
    }

    void overwrite(T data) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    void clear() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

}