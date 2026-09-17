public class Main {
    static void main(String[] args) {
        DLL playlist = new DLL();
        playlist.inisialisasi();

        Song song1 = new Song("Shelter", "Porter Robinson");
        Song song2 = new Song("Everything Goes On", "Porter Robinson");
        Song song3 = new Song("Never Gonna Give You Up", "Rick Astley");

        Node node1 = new Node(song1);
        Node node2 = new Node(song2);
        Node node3 = new Node(song3);

        // Nanti dipakai setelah method selesai
        playlist.addFirst(node1);
        playlist.addLast(node2);
        playlist.addLast(node3);

        playlist.printForward();
        System.out.println();
        playlist.printBackward();
    }
}