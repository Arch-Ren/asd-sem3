public class Matrik {
    private int nBaris, nKolom;
    private double[][] itemDn;

    //Constructor matriks input baris kolom
    public Matrik(int nBrs, int nKlm) {
        nBaris = nBrs;
        nKolom = nKlm;
        itemDn = new double[nBaris][nKolom];
    }

    //Constructor matriks dari array 2D
    public Matrik(double[][] A) {
        this(A.length, A[0].length); // panggil constructor
        this.nBaris = A.length;
        this.nKolom = A[0].length;

        for (int i = 0; i < nBaris; i++) {
            for (int j = 0; j < nKolom; j++) {
                this.itemDn[i][j] = A[i][j];
            }
        }
    }

    //Ambil jumlah baris dan kolom
    public int getNBaris() {
        return nBaris;
    }

    public int getNKolom() {
        return nKolom;
    }

    //ambil elemen dari baris dan kolom tertentu
    public double getItem(int idB, int idK) {
        return this.itemDn[idB][idK];
    }

    //ganti elemen matriks
    public void setItem(int idB, int idK, double dt) {
        this.itemDn[idB][idK] = dt;
    }

    /**
     * fungsi tambah antara dua matrik A dan B
     * @param A: Matrik
     * @param B: Matrik
     * @return Matrik hasil
     */
    public static Matrik tambah(Matrik A, Matrik B) {
        //cek ordo
        if (A.getNBaris() == B.getNBaris() && A.getNKolom() == B.getNKolom()) {
            Matrik hasil = new Matrik(A.getNBaris(), B.getNKolom());
            for (int i = 0; i < hasil.getNBaris(); i++) {
                for (int j = 0; j < hasil.getNKolom(); j++) {
                    hasil.setItem(i, j, (A.getItem(i, j)  + (B.getItem(i, j))));
                }
            }
            return hasil;
        } else {
            System.out.println("Matrik tidak dijumlahkan karena ordo tidak sama");
            return null;
        }
    }

    /**
     * fungsi static perkalian antara vektor dengan matrik
     * Syarat: lebar L sama dengan jumlah baris M
     * @param L: Vector (Larik)
     * @param M: Matrik
     * @return Vector (Larik) berdimensi nKolom dari M
     */
    public static Larik VektorKaliMatrik(Larik L, Matrik M) {
        Larik lHasil = null;
        Larik lKolom = null;

        if (L.getSize() == M.getNBaris()) {
            lHasil = new Larik(M.getNKolom());

            for (int i = 0; i < M.getNKolom(); i++) {
                lKolom = M.getKolom(i);
                double hasil = Larik.LarikKaliLarik(L, lKolom);
                System.out.println(hasil);
                lHasil.isiItem(i, hasil);
            }
        }

        return lHasil;
    }

    /**
     * fungsi static transpos suatu matrik
     * @param A: Matrik
     * @return Matrik tranpos
     */
    public static Matrik transpos(Matrik A) {
        Matrik transpose = new Matrik (A.getNKolom(), A.getNBaris());
        for (int i = 0; i < transpose.getNBaris(); i++) {
            for (int j = 0; j <  transpose.getNKolom(); j++) {
                transpose.setItem(i, j, A.getItem(j, i));
            }
        }
        return transpose;
    }

    /**
     * fungsi untuk mendapatkan vektor baris dari matrik
     * @param idBaris: indek baris yang akan diekstrak
     * @return Larik representasi baris
     */
    public Larik getBaris(int idBaris) {
        Larik l = new Larik(this.nKolom);

        for (int i = 0; i < this.nKolom; i++) {
            double itemBaris = this.getItem(idBaris, i);
            l.isiItem(i, itemBaris);
        }
        return l;
    }

    /**
     * fungsi untuk mendapatkan vektor kolom suatu matrik
     * @param idKolom: id kolom yang akan diekstrak
     * @return Larik representasi kolom
     */
    public Larik getKolom(int idKolom) {
        Larik l = new Larik(this.nBaris);

        for (int i = 0; i < this.nBaris; i++) {
            double itemKolom = this.getItem(i, idKolom);
            l.isiItem(i, itemKolom);
        }

        return l;
    }

    /**
     * procedure cetak
     * @param kom
     */
    public void cetak(String kom) {
        System.out.println(kom);

        for (int i = 0; i < this.nBaris; i++) {
            for (int j = 0; j < this.nKolom; j++) {
                System.out.printf("%.2f ", this.itemDn[i][j]);
            }

            System.out.println();
        }
    }
}

