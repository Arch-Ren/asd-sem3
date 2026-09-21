public class Node {
    Mahasiswa data;
    Node next;

    Node(Mahasiswa data) {
        this.data = data;
        this.next = null;
    }

    Node() {
        this.data = null;
        this.next = null;
    }
}
