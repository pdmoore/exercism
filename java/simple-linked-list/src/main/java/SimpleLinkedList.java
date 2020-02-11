import java.util.NoSuchElementException;

class SimpleLinkedList<Object> {

    Element head;


    public SimpleLinkedList() {
        head = null;
    }

    public SimpleLinkedList(Object[] values) {

        Element current = null;

        for (Object nextValue :
                values) {
            if (head == null) {
                head = new Element(nextValue);
                current = head;
            } else {
                Element next = new Element(nextValue);
                current.next = next;
                current = next;
            }
        }

    }

    public Integer size() {
        // TODO - remove guard clause and do once?
        if (head == null) {
            return 0;
        }

        int count = 1;
        Element next = head;
        while (next.next != null) {
            next = next.next;
            count++;
        }

        return count;
    }

    public Object pop() {
        if (head == null) {
            throw new NoSuchElementException();
        }

        Object valuePopped = head.value;

        head = head.next;

        return valuePopped;
    }

    public void push(Object i) {
        if (head == null) {
            head = new Element(i);
        } else {
            Element next = new Element(i);
            next.next = head;
            head = next;
        }
    }

    public void reverse() {

    }

    public Object[] asArray(Class<Object> characterClass) {
        return null;
    }


    class Element {
        Object value;
        Element next;

        public Element(Object it) {
            this.value = it;
            next = null;
        }
    }
}
