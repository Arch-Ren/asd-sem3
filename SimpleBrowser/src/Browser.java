public class Browser {
    Node head;
    Node tail;
    Node current;

    Browser() {
        Situs newTab = new Situs("Choose a website to visit", "New Tab");
        Node newTabNode = new Node(newTab);

        head = newTabNode;
        tail = newTabNode;
        current = newTabNode;
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

    void back() {
        if(isEmpty() || current == head){
            return;
        }
        current = current.prev;
    }

    void forward() {
        if(isEmpty() || current == tail){
            return;
        }
        current = current.next;
    }

    Situs getCurrent() {
        return current.data;
    }

    void showHistory() {
        Node temp = head.next;
        while (temp != null) {
            System.out.print(temp.data.namaSitus + " - " + temp.data.alamatSitus + "\n");
            temp = temp.next;
        }
    }
}
