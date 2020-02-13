import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class SimpleLinkedList<Object> {

    Element head;
    int count;

    public SimpleLinkedList() {
        head = null;
        count = 0;
    }

    public SimpleLinkedList(Object[] values) {
        this();

        Element current = null;

        for (Object nextValue :
                values) {
            push(nextValue);
        }
    }

    public Integer size() {
        return count;
    }

    public Object pop() {
        if (head == null) {
            throw new NoSuchElementException();
        }

        Object valuePopped = head.value;
        head = head.next;
        count--;
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
        count++;
    }

    public void reverse() {
        if (head == null) {
            return;
        }

        SimpleLinkedList<Object> reversed = new SimpleLinkedList<>();
        Element current = head;
        do {
            reversed.push(current.value);
            current = current.next;
        } while (current != null);

        head = reversed.head;
    }

    public Object[] asArray(Class<Object> characterClass) {
        List arrayList = new ArrayList<Object>();
        Element current = head;
        while (current != null) {
            arrayList.add(current.value);
            current = current.next;
        }
        return (Object[]) arrayList.toArray();
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
