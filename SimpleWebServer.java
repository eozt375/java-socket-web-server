import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleWebServer {
    private final int port;
    private final HtmlContentProvider contentProvider;
    private final HttpResponseBuilder responseBuilder;
    private boolean isRunning;

    public SimpleWebServer(int port, HtmlContentProvider contentProvider, HttpResponseBuilder responseBuilder) {
        this.port = port;
        this.contentProvider = contentProvider;
        this.responseBuilder = responseBuilder;
        this.isRunning = false;
    }

    public void start() {
        isRunning = true;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("==================================================");
            System.out.println("Web Sunucusu başlatıldı!");
            System.out.println("Tarayıcınızdan erişmek için: http://localhost:" + port);
            System.out.println("==================================================");

            while (isRunning) {
                Socket clientSocket = serverSocket.accept();
                ClientHandler handler = new ClientHandler(clientSocket, contentProvider, responseBuilder);
                Thread thread = new Thread(handler);
                thread.start();
            }
        } catch (IOException e) {
            System.err.println("Sunucu hatası (Port " + port + " kullanımda olabilir): " + e.getMessage());
        }
    }

    public void stop() {
        this.isRunning = false;
    }
}