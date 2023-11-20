import java.util.List;

class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;

    void insert(T value) {
        if (null == root) {
            Node<T> newNode = new Node<>(value);
            root = newNode;
        } else {
            insert(root, value);
        }
    }

    private void insert(Node<T> node, T value) {
        T data = node.getData();
        if (value.compareTo(data) <= 0) {
            Node<T> newNode = new Node<>(value);
            root.left = newNode;
        } else {
            Node<T> newNode = new Node<>(value);
            root.right = newNode;
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
        private Node<T> right = null;

        public Node(T data) {
            this.data = data;
        }

        Node<T> getLeft() {
            return left;
        }

        Node<T> getRight() {
            return right;
        }

        T getData() {
            return data;
        }

    }
}
