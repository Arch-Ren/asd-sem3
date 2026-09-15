public class Main{
    static void main() {
        SLL list = new SLL();

        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");

        System.out.println(list.size);
        list.addFirst(A);
        list.addLast(B);
        list.addLast(D);
        list.insertAfter(B, C);
        System.out.println(list.size);
        list.print();

        list.removeFirst();
        list.print();

        list.addFirst(A);
        list.removeLast();
        list.print();

        list.addLast(D);
        list.removeAfter(B);
        list.print();

        System.out.println(list.contains("B"));
        System.out.println(list.contains(26));
    }
}