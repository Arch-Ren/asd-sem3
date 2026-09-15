import java.util.Scanner;

class Parcel {
    String trackingId;
    String recipientName;

    Parcel(String trackingId, String recipientName) {
        this.trackingId = trackingId;
        this.recipientName = recipientName;
    }
}

// Tugas 1 - Lengkapi Class Node berdasarkan ADT Linked List
class Node {
    // TODO: Definisikan atribut dan constructor Node
    Parcel data;
    Node next;

    Node(Parcel A){
        this.data = A;
        this.next = null;
    }
}

class SingleLinkedList {
    Node head;
    Node tail;
    int size;

    void initialize() {
        head = null;
        tail = null;
        size = 0;
    }

    boolean isEmpty() {
        return head == null;
    }

    int size() {
        return size;
    }

    void addFirst(Node input) {
        if (isEmpty()) {
            head = input;
            tail = input;
        } else {
            input.next = head;
            head = input;
        }
        size++;
    }

    //Tugas 2 - Lengkapi Method 
    void addLast(Node input) {
        // lengkapi bagian ini. logicnya mirip kyk addFirst
        if(isEmpty()) {
            head = tail = input;
        } else {
            tail.next = input;
            tail = input;
        }
        size++;
    }

    // Tugas 3 - Method menghapus parsel 
    void removeParcel(String trackingId) {
        // TODO: Temukan dan hapus parcel dgn ID yg sesuai
        // Perhatikan head, tail, dan ukuran SLL
        Node current = head;
        while (current != null) {
            if(current.data.trackingId.equals(trackingId)) {
                if(current == head) {
                    head = current.next;
                    current.next = null;
                    size--;
                    return;
                } else if (current == tail) {
                    Node temp = head;
                    while(temp.next != tail) {
                        temp = temp.next;
                    }
                    tail = temp;
                    temp.next = null;
                    size--;
                    return;
                } else {
                    Node hapus = current;
                    Node temp = head;
                    while (temp.next != hapus) {
                        temp = temp.next;
                    }
                    temp.next = hapus.next;
                    hapus.next = null;
                    size--;
                    return;
                }
            }
            current = current.next;
        }
    }

    void printList() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data.trackingId + " " + current.data.recipientName);
            current = current.next;
        }
        System.out.println("Size: " + size);
    }
}

public class LiveCode2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SingleLinkedList list = new SingleLinkedList();
        list.initialize();

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            String trackingId = scanner.next();
            String recipientName = scanner.next();
            Parcel parcel = new Parcel(trackingId, recipientName);

            list.addLast(new Node(parcel));
        }

        String deliveredId = scanner.next();
        list.removeParcel(deliveredId);
        list.printList();

        scanner.close();
    }
}