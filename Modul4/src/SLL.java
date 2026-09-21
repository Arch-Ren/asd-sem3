public class SLL {
    Node head,tail;
    int size;

    void inisialisasi() {
        head=null;
        tail=null;
        size=0;
    }

    boolean isEmpty() {
        return (size==0);
    }

    int size() {
        return size;
    }

    void addFirst(Node input) {
        if (isEmpty()) {
            head=input;
            tail=input;
        } else {
            input.next = head;
            head = input;
        } size++;
    }

    void addLast(Node input) {
        if (isEmpty()) {
            head = input;
            tail = input;
        } else {
            tail.next = input;
            tail = input;
        } size++;
    }

    void penghapusan(Node input) {
        Node current = head;
        while (current != null) {
            if (current == input) {
                if (current == head) {
                    head = current.next;
                    if (current == tail) {
                        tail = null;
                    }
                    current.next = null;
                } else if (current == tail) {
                    Node temp = head;
                    while (temp.next != tail) {
                        temp = temp.next;
                    }
                    tail = temp;
                    tail.next = null;
                } else {
                    Node temp = head;
                    while (temp.next != current) {
                        temp = temp.next;
                    }
                    temp.next = current.next;
                    current.next = null;
                }
                size--;
                return;
            }
            current = current.next;
        }
    }

    void penyisipan(Node after, Node input) {
        Node current = head;
        while (current != null) {
            if (current == after) {
                input.next = current.next;
                current.next = input;
                if (current == tail) {
                    tail = input;
                }
                size++;
                return;
            }
            current = current.next;
        }
    }

    void pencarian(Node input) {
        Node current = head;
        int i = 0;
        while (current != null) {
            if (current == input) {
                System.out.println("Node yang dicari ada di index " + i);
                return;
            }
            current = current.next;
            i++;
        }
    }

    Object pengaksesan(Node input) {
        Node current = head;
        while (current != null) {
            if (current == input) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    Object pengaksesan (int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    void insertSortDesc(Node input) {
        if(isEmpty()){
            head = input;
            tail = input;
            size++;
            return;
        }
        if(input.data.getIpk() > head.data.getIpk()) {
            addFirst(input);
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data.getIpk() < input.data.getIpk()) {
                input.next = current.next;
                current.next = input;
                size++;
                return;
            }

            current = current.next;
        }
        current.next = input;
        tail = input;
        size++;
    }
}