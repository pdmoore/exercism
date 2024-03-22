class EmptyBufferException extends Exception {}
class FullBufferException extends Exception {}

class CircularBuffer {

    int only_item
    int item_count

    CircularBuffer(int capacity) {
        item_count = 0
        only_item = 0
    }

    def clear() {
        throw new UnsupportedOperationException('Clear implementation is missing')
    }

    def read() {
        if (item_count == 0) {
            throw new EmptyBufferException()
        }
        return only_item
    }

    def write(int item) {
        item_count++
        only_item = item
    }

    def overwrite(int item) {
        throw new UnsupportedOperationException('Overwrite implementation is missing')
    }
}
