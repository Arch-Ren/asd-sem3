public class SLL {
    Node head;
    Node tail;
    int size;

    SLL() {
        head = null;
        tail = null;
        size = 0;
    }

    SLL(Node A){
        head = A;
        tail = A;
        size = 1;
    }

    boolean isEmpty() {
        return head == null;
    }

    void addFirst(Node A){
        if(isEmpty()) {
            head = A;
            tail = A;
        } else {
            A.next = head;
            head = A;
        }
        size++;
    }

    void addLast(Node A){
        if(isEmpty()) {
            head = A;
            tail = A;
        } else {
            tail.next = A;
            tail = A;
        }
        size++;
    }

    void print() {
        if(isEmpty()) {
            System.out.println("List saat ini kosong");
            return;
        }
        Node current = head;
        while(current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
            if(current == null) {
                System.out.print("null");
            }
        }
        System.out.println();
    }

    boolean contains(Object A) {
        if(isEmpty()) {
            return false;
        }
        Node current = head;
        while(current != null) {
            if(current.data.equals(A)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    void insertAfter(Node before, Node A) {
        if(isEmpty()) {
            System.out.println("List saat ini kosong");
            return;
        }
        Node current = head;
        while(current != null) {
            if(current.data.equals(before.data)) {
                A.next = current.next;
                current.next = A;
                size++;
                if(current == tail) {
                    tail = A;
                }
                break;
            }
            current = current.next;
        }
    }

    void removeFirst(){
        if(isEmpty()) {
            System.out.println("List saat ini kosong");
            return;
        } else if (head == tail) {
            head = tail = null;
        } else {
            Node current = head;
            head = current.next;
            current.next = null;
        }
        size--;
    }

    void removeLast() {
        if(isEmpty()) {
            System.out.println("List saat ini kosong");
            return;
        } else if (tail == head) {
            head = tail = null;
        } else {
            Node current = head;
            while(current.next != tail) {
                current = current.next;
            }
            tail = current;
            current.next = null;
        }
        size--;
    }

    void removeAfter(Node A) {
        if(isEmpty()) {
            System.out.println("List saat ini kosong");
            return;
        }
        Node current = head;
        while(current != null) {
            if(current.data.equals(A.data)) {
                if(current == tail) {
                    System.out.println("objek yang dicari adalah tail. Tidak ada yang dihapus");
                    return;
                }
                Node hapus = current.next;
                current.next = current.next.next;
                if(hapus == tail) {
                    tail = current;
                }
                hapus.next = null;
                size--;
                return;
            }
            current = current.next;
        }
    }
}
