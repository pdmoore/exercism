import java.util.List;

class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;

    void insert(T value) {
        Node<T> newNode = new Node<>(value);

        if (null == root) {
            root = newNode;
        }
    }

    List<T> getAsSortedList() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    List<T> getAsLevelOrderList() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    Node<T> getRoot() {
        return root;
    }

    static class Node<T> {

        private final T data;
        private final Node<T> left = null;
        private final Node<T> right = null;

        public Node(T data) {
            this.data = data;
        }

        Node<T> getLeft() {
            throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
        }

        Node<T> getRight() {
            throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
        }

        T getData() {
            return data;
        }

    }
}
