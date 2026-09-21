public class Mahasiswa {
    String nim;
    String nama;
    Double ipk;

    Mahasiswa(String nim, String nama, Double ipk) {
        this.nim = nim;
        this.nama = nama;
        this.ipk = ipk;
    }

    Double getIpk() {
        return ipk;
    }

    String getNim() {
        return nim;
    }

    String getNama() {
        return nama;
    }
}
