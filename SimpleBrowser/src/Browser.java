public class Browser {
    Node head;
    Node tail;
    Node current;

    Browser() {
        head = null;
        tail = null;
        current = null;
    }

    boolean isEmpty() {
        return head == null;
    }

    void visit(Node input) {
        if(isEmpty()){
            head = input;
            tail = input;
            current = input;
        } else {
            current.next = input;
            input.prev = current;
            tail = input;
            current = input;
        }
    }
}
