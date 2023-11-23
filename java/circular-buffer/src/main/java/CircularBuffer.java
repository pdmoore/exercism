class CircularBuffer<T> {

    CircularBuffer(final int size) {

    }

    T read() throws BufferIOException {
        throw new BufferIOException("Tried to read from empty buffer");
    }

    void write(T data) throws BufferIOException {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    void overwrite(T data) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    void clear() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

}