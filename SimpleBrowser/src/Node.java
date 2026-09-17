public class Node {
    Situs data;
    Situs prev;
    Situs next;

    Node(Situs data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
