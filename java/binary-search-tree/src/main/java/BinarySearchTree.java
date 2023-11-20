import java.util.ArrayList;
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
            if (node.getLeft() == null) {
                Node<T> newNode = new Node<>(value);
                node.left = newNode;
            } else {
                insert(node.getLeft(), value);
            }
        } else {
            if (node.getRight() == null) {
                Node<T> newNode = new Node<>(value);
                node.right = newNode;
            } else {
                insert(node.getRight(), value);
            }
        }
    }

    List<T> getAsSortedList() {
        List<T> result = new ArrayList<>();
        depthTraversal(root, result);
        return result;
    }

    private void depthTraversal(Node<T> node, List<T> result) {
        if (node == null) {
            return;
        }
        result.add(node.getData());
        depthTraversal(node.getLeft(), result);
        depthTraversal(node.getRight(), result);
    }

    List<T> getAsLevelOrderList() {
        List<T> result = new ArrayList<>();
        result.add(root.getData());
        breadthTraversal(root, result);
        return result;
    }

    private void breadthTraversal(Node<T> node, List<T> result) {
        if (node == null) {
            return;
        }
        if (node.getLeft() != null) {
            result.add((node.getLeft().getData()));
        }
        if (node.getRight() != null) {
            result.add(node.getRight().getData());
        }

        breadthTraversal(node.getLeft(), result);
        breadthTraversal(node.getRight(), result);
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
