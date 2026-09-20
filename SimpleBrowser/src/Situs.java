public class Situs {
    String alamatSitus;
    String namaSitus;
    String favicon;
    String picture;

    Situs(String url, String title, String favIcon, String picture) {
        this.alamatSitus = url;
        this.namaSitus = title;
        this.favicon = favIcon;
        this.picture = picture;
    }
}
