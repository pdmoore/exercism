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
        readIndex = incrementIndex(readIndex);
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
        writeIndex = incrementIndex(writeIndex);
    }


    void overwrite(T data) {
        readIndex = incrementIndex(writeIndex);
        this.data.set(writeIndex, data);
        writeIndex = incrementIndex(writeIndex);
    }

    void clear() {
        data = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            data.add(null);
        }
        writeIndex = 0;
        readIndex = -1;
    }

    private int incrementIndex(int bufferIndex) {
        bufferIndex += 1;
        if (bufferIndex >= size) {
            bufferIndex = 0;
        }
        return bufferIndex;
    }
}