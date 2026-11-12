import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ClientHandler implements Runnable {
    private final Socket clientSocket;
    private final HtmlContentProvider contentProvider;
    private final HttpResponseBuilder responseBuilder;

    public ClientHandler(Socket clientSocket, HtmlContentProvider contentProvider, HttpResponseBuilder responseBuilder) {
        this.clientSocket = clientSocket;
        this.contentProvider = contentProvider;
        this.responseBuilder = responseBuilder;
    }

    @Override
    public void run() {
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(), StandardCharsets.UTF_8));
            OutputStream outputStream = clientSocket.getOutputStream()
        ) {
            // Tarayıcıdan gelen HTTP isteğinin ilk satırını oku (Örn: GET / HTTP/1.1)
            String requestLine = reader.readLine();
            if (requestLine != null && !requestLine.isEmpty()) {
                System.out.println("[İSTEK ALINDI] " + clientSocket.getInetAddress() + " -> " + requestLine);
            }

            // HTML içeriğini al ve HTTP 200 OK paketi haline getir
            String htmlContent = contentProvider.getHtmlContent();
            byte[] httpResponse = responseBuilder.buildSuccessResponse(htmlContent);

            // Yanıtı tarayıcıya gönder
            outputStream.write(httpResponse);
            outputStream.flush();

        } catch (IOException e) {
            System.err.println("İstemci isteği işlenirken hata oluştu: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("Soket kapatılırken hata oluştu: " + e.getMessage());
            }
        }
    }
}