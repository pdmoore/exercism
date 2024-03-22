class EmptyBufferException extends Exception {}
class FullBufferException extends Exception {}

class CircularBuffer {
    ArrayList items

    CircularBuffer(int capacity) {
        items = []
    }

    def clear() {
        throw new UnsupportedOperationException('Clear implementation is missing')
    }

    def read() {
        if (items.size() == 0) {
            throw new EmptyBufferException()
        }
        return items.remove(0)
    }

    def write(int item) {
        items.add(item)
    }

    def overwrite(int item) {
        throw new UnsupportedOperationException('Overwrite implementation is missing')
    }
}
