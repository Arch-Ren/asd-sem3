import java.util.Scanner;

public class LiveCode1 {

    public static void tampilkanArray(int[] kodeBuku) {
        for (int i = 0; i < kodeBuku.length; i++) {
            System.out.print(kodeBuku[i] + " ");
        }
        System.out.println();
    }

    public static int cariBuku(int[] kodeBuku, int kodeDicari) {
        for (int i = 0; i < kodeBuku.length; i++) {
            if (kodeDicari == kodeBuku[i]) {
                return i;
            }
        }
        return -1;
    }

    public static int hitungKemunculan(int[] kodeBuku, int kodeDicari) {
        int count = 0;
        for (int i = 0; i < kodeBuku.length; i++) {
            if (kodeDicari == kodeBuku[i]) {
                count += 1;
            }
        }
        if (count > 0) {
            return count;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] kodeBuku = new int[n];
        //System.out.println("debug 4");

        for (int i = 0; i < n; i++) {
            kodeBuku[i] = scanner.nextInt();
        }
        //System.out.println("debug 5");

        int kodeDicari = scanner.nextInt();
        //System.out.println("debug 6");

        //System.out.println("debug 1");
        tampilkanArray(kodeBuku);
        //System.out.println("Debug 2");
        System.out.println(cariBuku(kodeBuku, kodeDicari));
        //System.out.println("debug 3");
        System.out.println(hitungKemunculan(kodeBuku, kodeDicari));

        scanner.close();
    }
}