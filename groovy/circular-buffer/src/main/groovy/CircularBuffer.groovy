class EmptyBufferException extends Exception {}
class FullBufferException extends Exception {}

class CircularBuffer {
    int item_count
    ArrayList items

    CircularBuffer(int capacity) {
        item_count = 0
        items = []
    }

    def clear() {
        throw new UnsupportedOperationException('Clear implementation is missing')
    }

    def read() {
        if (item_count == 0) {
            throw new EmptyBufferException()
        }
        return items.get(0)
    }

    def write(int item) {
        item_count++
        items.add(item)
    }

    def overwrite(int item) {
        throw new UnsupportedOperationException('Overwrite implementation is missing')
    }
}
