# Java Socket Tabanlı Basit Web Sunucusu (HTTP Server)

Bu proje, herhangi bir üçüncü parti kütüphane veya hazır web çatısı (framework) kullanılmadan, yalnızca standart Java (`java.net` ve `java.io`) kütüphaneleri ve **TCP Socket Programlama** kullanılarak geliştirilmiş hafif sıklet bir HTTP Web Sunucusudur. 

Uygulama, **SOLID** nesne yönelimli tasarım prensiplerine uygun olarak modüler bir mimariyle tasarlanmıştır ve **1989** numaralı port üzerinden gelen HTTP isteklerine özel biçimlendirilmiş bir HTML sayfası ile yanıt vermektedir.

## 🚀 Özellikler

* **Sıfır Dış Bağımlılık:** Yalnızca standart JDK kütüphaneleri (`ServerSocket`, `Socket`, `BufferedReader`, `OutputStream`) kullanılmıştır.
* **HTTP/1.1 Uyumlu Yanıt:** Modern web tarayıcılarının sorunsuz şekilde render edebilmesi için standart `HTTP/1.1 200 OK`, `Content-Type` ve `Content-Length` başlıkları (headers) dinamik olarak üretilir.
* **Multi-Threading (Çoklu İş Parçacığı):** Her istemci bağlantısı ayrı bir `Thread` (`ClientHandler`) üzerinde işlenerek sunucunun eşzamanlı isteklere yanıt vermesi sağlanır.
* **SOLID Mimarisi:** Sorumluluklar ayrıştırılmış (`SRP`), içerik üretimi soyutlanmış (`OCP`, `LSP`, `ISP`) ve bağımlılıklar dışarıdan enjekte edilmiştir (`DIP`).

## 📂 Proje Mimarisi

```text
├── Main.java                       # Uygulamanın giriş noktası ve bağımlılıkların enjekte edildiği sınıf
├── SimpleWebServer.java            # 1989 portunu dinleyen ve soket bağlantılarını yöneten sunucu sınıfı
├── ClientHandler.java              # İstemci isteklerini ayrı bir Thread'de işleyen Runnable sınıfı
├── HttpResponseBuilder.java        # HTML içeriğini HTTP/1.1 protokol paketine dönüştüren sınıf
├── HtmlContentProvider.java        # İçerik sağlayıcılar için soyut arayüz (Interface)
└── StudentProfileHtmlProvider.java # Öğrenci bilgilerini ve biyografiyi içeren HTML/CSS üreticisi