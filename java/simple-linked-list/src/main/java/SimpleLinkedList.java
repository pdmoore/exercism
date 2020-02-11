class SimpleLinkedList<Object> {

    Element head;


    public SimpleLinkedList() {

    }

    public SimpleLinkedList(Object[] values) {

        Element current = null;

        for (Object it :
                values) {
            if (head == null) {
                head = new Element(it);
                current = head;
            } else {
                Element next = new Element(it);
                current.next = next;
                current = next;
            }
        }

    }

    public Integer size() {
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
        return null;
    }

    public void push(Object i) {

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
