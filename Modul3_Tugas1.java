    import java.util.Arrays;

    public class Modul3_Tugas1 {

        public static int[] sorting(int[] n) {
            Arrays.sort(n);
            return n;
        }

        public static int rataRata(int[] n) {
            int total = 0;
            for (int i : n) {
                total += i;
            }
            int rata = total / n.length;
            return rata;
        }

        public static boolean cekGanjil(int n) {
            if (n % 2 == 1) {
                return true;
            }
            return false;
        }

        public static boolean cekPrima(int n) {
            boolean temp = true;
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    temp = false;
                    break;
                }
            }
            if (temp) {
                return true;
            }
            return false;
        }

        public static int[][] inputArray2D(int row, int column, int[] n) {
            int[][] array = new int[row][column];
            int temp = 0;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] = n[temp];
                    temp++;
                }
            }
            return array;
        }

        public static void main(String[] args) {
            int[] data = {30, 87, 90, 3, 1, 50, 23, 24, 25, 23, 40, 35, 47, 2, 33};

            //Urutkan
            sorting(data);
            System.out.println("Data setelah diurutkan adalah: ");
            int comma = 0;
            for (int i : data) {
                System.out.print(i);
                if (comma != data.length - 1) {
                    System.out.print(", ");
                }
                comma++;
            }
            System.out.println("\n");

            //Rata-rata
            int rata = rataRata(data);
            System.out.println("Rata-rata dari data tersebut adalah : " + rata);
            System.out.println();

            //maks min
            System.out.println("Nilai maks dari data tersebut adalah: " + data[data.length -1]);
            System.out.println("Nilai min dari data tersebut adalah : " + data[0]);
            System.out.println();

            //bilangan ganjil dan prima
            System.out.print("Data bilangan ganjil saja: ");
            for (int i : data) {
                boolean cekGanjil = cekGanjil(i);
                if (cekGanjil) {
                    System.out.print(i + ", ");
                }
            }
            System.out.println();
            System.out.print("Data bilangan prima saja: ");
            for (int i : data) {
                boolean cekPrima = cekPrima(i);
                if (cekPrima && i != 1) {
                    System.out.print(i + ", ");
                }
            }
            System.out.println("\n");

            //array 2D
            int[][] array2D = inputArray2D(3, 5, data);
            for (int i = 0; i < array2D.length; i++) {
                System.out.print("[ ");
                for (int j = 0; j < array2D[i].length; j++) {
                    System.out.print(array2D[i][j] + " ");
                }
                System.out.println("]");
            }
        }
    }
