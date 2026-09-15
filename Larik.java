public class Larik {
    private int nItem;
    private double[] item;

    public Larik(int n) {
        nItem = n;
        item = new double[n];
    }

    public int getSize() {
        return nItem;
    }

    public double getItem(int i) {
        return item[i];
    }

    public void isiItem(int i, double nilai) {
        item[i] = nilai;
    }

    public void cetak(String komentar) {
        System.out.println(komentar);
        for (int i = 0; i < nItem; i++) {
            System.out.printf("%.2f ", item[i]);
        }
        System.out.println();
    }

    public static double LarikKaliLarik(Larik A, Larik B) {
        double hasil = 0;

        for (int i = 0; i < A.getSize(); i++) {
            hasil += A.getItem(i) * B.getItem(i);
        }

        return hasil;
    }
}