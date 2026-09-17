public class DLL {
    Node head;
    Node tail;
    int size;

    void inisialisasi() {
        head = null;
        tail = null;
        size = 0;
    }

    boolean isEmpty() {
        return head == null;
    }

    int getSize() {
        return size;
    }

    void addFirst(Node input){
        if(isEmpty()) {
            head = input;
            tail = input;
        } else {
            head.prev = input;
            input.next = head;
            head = input;
        }
        size++;
    }

    void addLast(Node input) {
        if(isEmpty()) {
            head = input;
            tail = input;
        } else {
            input.prev = tail;
            tail.next = input;
            tail = input;
        }
        size++;
    }

    void addAfter(String title, Node input) {
        if(isEmpty()) {
            System.out.println("Title tidak ditemukan");
            return;
        } else {
            Node current = head;
            while (current != null) {
                if (current.data.title.equals(title)) {
                    if (current == tail) {
                        addLast(input);
                        return;
                    }

                    current.next.prev = input;
                    input.next = current.next;
                    input.prev = current;
                    current.next = input;
                    size++;
                    return;
                }
                current = current.next;
            }
        }
    }

    void addBefore(String title, Node input) {
        if(isEmpty()) {
            System.out.println("Tidak ada lagu");
            return;
        }
        Node current = head;
        while(current != null) {
            if(current.data.title.equals(title)) {
                if(current == head) {
                    addFirst(input);
                    return;
                }
                input.next = current;
                input.prev = current.prev;
                current.prev = input;
                input.prev.next = input;
                size++;
                return;
            }
            current = current.next;
        }
        System.out.println("Judul tidak ditemukan");
    }

    void removeFirst() {
        if(isEmpty()) {
            System.out.println("Tidak ada lagu");
            return;
        } else if(size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    void removeLast() {
        if(isEmpty()) {
            System.out.println("Tidak ada lagu");
            return;
        } else if(size == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    void removeTitle(String title){
        if(isEmpty()) {
            System.out.println("Tidak ada lagu");
            return;
        }
        Node current = head;
        while(current != null) {
            if(current.data.title.equals(title)) {
                if(current == head) {
                    removeFirst();
                    return;
                } else if (current == tail) {
                    removeLast();
                    return;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    size--;
                    return;
                }
            }
            current = current.next;
        }
        System.out.println("Judul tidak ditemukan");
    }

    void removeNode(Node input) {
        if(isEmpty()) {
            System.out.println("Tidak ada lagu");
            return;
        }
        if(input == head) {
            removeFirst();
            return;
        }
        if(input == tail) {
            removeLast();
            return;
        }
        input.prev.next = input.next;
        input.next.prev = input.prev;
        size--;
    }

    void printForward() {
        Node current = head;
        while(current != null) {
            System.out.println(current.data.title + " - " + current.data.artist);
            current = current.next;
        }
    }

    void printBackward() {
        Node current = tail;
        while(current != null) {
            System.out.println(current.data.title + " - " + current.data.artist);
            current = current.prev;
        }
    }
}
