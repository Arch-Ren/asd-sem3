public class Node {
    Song data;
    Node next;
    Node prev;

    public Node(Song data) {
        this.data = data;
        this.prev =null;
        this.next = null;
    }
}
