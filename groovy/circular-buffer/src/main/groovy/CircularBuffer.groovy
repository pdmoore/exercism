class EmptyBufferException extends Exception {}
class FullBufferException extends Exception {}

class CircularBuffer {
    ArrayList items
    int capacity

    CircularBuffer(int capacity) {
        this.capacity = capacity
        clear()
    }

    def clear() {
        items = []
    }

    def read() {
        if (items.size() == 0) {
            throw new EmptyBufferException()
        }
        return items.remove(0)
    }

    def write(int item) {
        if (items.size() == capacity) {
            throw new FullBufferException()
        }
        items.add(item)
    }

    def overwrite(int item) {
        throw new UnsupportedOperationException('Overwrite implementation is missing')
    }
}
