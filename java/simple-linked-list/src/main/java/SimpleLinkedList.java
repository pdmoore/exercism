import java.util.ArrayList;
import java.util.List;
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
            push(nextValue);
        }
    }

    public Integer size() {
        int count = 0;
        Element current = head;
        while (current != null) {
            count++;
            current = current.next;
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
        //TODO assumes there is at least one item in current list
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
