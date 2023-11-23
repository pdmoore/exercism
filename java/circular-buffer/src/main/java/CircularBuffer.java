import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class CircularBuffer<T> {

    private int writeIndex;
    private  int readIndex;
    List<T> data;
    private final int size;

    CircularBuffer(final int size) {
        this.size = size;
        clear();
    }

    T read() throws BufferIOException {
        if (readIndex == -1 || this.data.get(readIndex) == null) {
            throw new BufferIOException("Tried to read from empty buffer");
        }

        T returnVal = this.data.get(readIndex);
        this.data.set(readIndex, null);
        readIndex += 1;
        if (readIndex >= size) {
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
        if (writeIndex >= size) {
            writeIndex = 0;
        }
    }

    void overwrite(T data) {
        // TODO - readIndex needs updated to not point to new writeIndex
        readIndex = writeIndex + 1;
        if (readIndex >= size) {
            readIndex = 0;
        }

        this.data.set(writeIndex, data);
        writeIndex += 1;
        if (writeIndex >= size) {
            writeIndex = 0;
        }
    }

    void clear() {
        data = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            data.add(null);
        }
        writeIndex = 0;
        readIndex = -1;
    }
}