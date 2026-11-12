public class Main {

    private static final int PORT = 1989;

    public static void main(String[] args) {
        // Kendi ad-soyad ve öğrenci numaranızı buraya giriniz
        HtmlContentProvider profileProvider = new StudentProfileHtmlProvider(
                "Enes Öztürk",
                "1250505064"
        );

        HttpResponseBuilder responseBuilder = new HttpResponseBuilder();

        SimpleWebServer server = new SimpleWebServer(PORT, profileProvider, responseBuilder);
        server.start();
    }
}
