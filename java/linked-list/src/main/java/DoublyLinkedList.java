public class DoublyLinkedList<T> {

    class Node {
        Node prev;
        Node next;
        T value;

        public Node(T t) {
            value = t;
            prev = null;
            next = null;
        }
    };

    private Node back;
    private Node front;

    public void push(T t) {
        Node n = new Node(t);

        if (back == null) {
            back = n;
            front = n;
        } else {
            back.next = n;
            n.prev = back;
            back = n;
        }
    }

    public T pop() {
        T value = back.value;

        Node dispose = back;
        if (back.prev != null) {
            back.prev.next = null;
            back = back.prev;
        } else {
            back = null;
        }
        dispose.prev = null;
        return value;
    }

    public T shift() {
        T value = front.value;

        Node dispose = front;
        if (front.next != null) {
            front.next.prev = null;
            front = front.next;
        } else {
            front = null;
        }
        dispose.next = null;
        return value;
    }

    public void unshift(T t) {
        Node n = new Node(t);

        if (front == null) {
            front = n;
            back = n;
        } else {
            front.prev = n;
            n.next = front;
            front = n;
        }

    }
}
