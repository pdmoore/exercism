import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class CircularBuffer<T> {

    private int writeIndex;
    private  int readIndex;
    List<T> data;

    CircularBuffer(final int size) {
        data = new LinkedList<>();
        // create LL of size with null data
        for (int i = 0; i < size; i++) {
            data.add(null);
        }
        writeIndex = 0;
        readIndex = -1;
    }

    T read() throws BufferIOException {
        if (readIndex == -1 || this.data.get(readIndex) == null) {
            throw new BufferIOException("Tried to read from empty buffer");
        }

        T returnVal = this.data.get(readIndex);
        this.data.set(readIndex, null);
        readIndex += 1;
        if (readIndex >= data.size()) {
            readIndex = 0;
        }
        return returnVal;
    }

    void write(T data) throws BufferIOException {
        if (readIndex == -1) {
            readIndex = 0;
        }
        if (this.data.get(writeIndex) != null) {
            throw new BufferIOException("Tried to write to full buffer");
        }
        this.data.set(writeIndex, data);
        writeIndex += 1;
        if (writeIndex >= this.data.size()) {
            writeIndex = 0;
        }
    }

    void overwrite(T data) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    void clear() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

}