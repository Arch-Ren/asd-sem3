public class Node {
    Situs data;
    Node prev;
    Node next;

    Node(Situs data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
