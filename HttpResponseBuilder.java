import java.nio.charset.StandardCharsets;

public class HttpResponseBuilder {

    public byte[] buildSuccessResponse(String htmlBody) {
        byte[] bodyBytes = htmlBody.getBytes(StandardCharsets.UTF_8);
        
        String headers = "HTTP/1.1 200 OK\r\n" +
                         "Content-Type: text/html; charset=UTF-8\r\n" +
                         "Content-Length: " + bodyBytes.length + "\r\n" +
                         "Connection: close\r\n" +
                         "\r\n";
        
        byte[] headerBytes = headers.getBytes(StandardCharsets.UTF_8);
        byte[] fullResponse = new byte[headerBytes.length + bodyBytes.length];
        
        System.arraycopy(headerBytes, 0, fullResponse, 0, headerBytes.length);
        System.arraycopy(bodyBytes, 0, fullResponse, headerBytes.length, bodyBytes.length);
        
        return fullResponse;
    }
}