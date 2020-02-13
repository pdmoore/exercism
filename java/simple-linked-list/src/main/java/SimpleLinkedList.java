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
            Element next = new Element(i, head);
            head = next;
        }
        count++;
    }

    public void reverse() {
        Element oldListPointer = head;
        head = null;
        while(oldListPointer != null) {
            push(oldListPointer.value);
            oldListPointer = oldListPointer.next;
        }
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
        final Object value;
        final Element next;

        public Element(Object it) {
            this.value = it;
            this.next = null;
        }

        public Element(Object it, Element next) {
            this.value = it;
            this.next = next;
        }
    }
}
