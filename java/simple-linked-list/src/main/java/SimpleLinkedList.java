import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class SimpleLinkedList<T> {

    Element head;
    int count;

    public SimpleLinkedList() {
        head = null;
        count = 0;
    }

    public SimpleLinkedList(T[] values) {
        this();

        for (T nextValue :
                values) {
            push(nextValue);
        }
    }

    public Integer size() {
        return count;
    }

    public T pop() {
        if (head == null) {
            throw new NoSuchElementException();
        }

        T valuePopped = head.value;
        head = head.next;
        count--;
        return valuePopped;
    }

    public void push(T i) {
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

    public T[] asArray(Class<T> characterClass) {
        List arrayList = new ArrayList<T>();
        Element current = head;
        while (current != null) {
            arrayList.add(current.value);
            current = current.next;
        }
        return (T[]) arrayList.toArray();
    }


    class Element {
        final T value;
        final Element next;

        public Element(T it) {
            this.value = it;
            this.next = null;
        }

        public Element(T it, Element next) {
            this.value = it;
            this.next = next;
        }
    }
}
