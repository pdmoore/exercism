import java.util.List;

class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;

    void insert(T value) {
        Node<T> newNode = new Node<>(value);

        if (null == root) {
            root = newNode;
        } else {
            T data = root.getData();
            if (value.compareTo(data) < 0) {
                root.left = newNode;
            } else {

            }

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
        private Node<T> left = null;
        private final Node<T> right = null;

        public Node(T data) {
            this.data = data;
        }

        Node<T> getLeft() {
            return left;
        }

        Node<T> getRight() {
            throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
        }

        T getData() {
            return data;
        }

    }
}
