public class StudentProfileHtmlProvider implements HtmlContentProvider {
    private final String fullName;
    private final String studentNumber;

    public StudentProfileHtmlProvider(String fullName, String studentNumber) {
        this.fullName = fullName;
        this.studentNumber = studentNumber;
    }

    @Override
    public String getHtmlContent() {
        return "<!DOCTYPE html>\n" +
               "<html lang=\"tr\">\n" +
               "<head>\n" +
               "    <meta charset=\"UTF-8\">\n" +
               "    <title>" + fullName + " - Kişisel Web Sayfası</title>\n" +
               "    <style>\n" +
               "        body {\n" +
               "            background-color: #f0f4f8;\n" +
               "            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;\n" +
               "            color: #2d3748;\n" +
               "            margin: 40px;\n" +
               "            line-height: 1.6;\n" +
               "        }\n" +
               "        .card {\n" +
               "            background-color: #ffffff;\n" +
               "            max-width: 700px;\n" +
               "            margin: 0 auto;\n" +
               "            padding: 35px;\n" +
               "            border-radius: 12px;\n" +
               "            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);\n" +
               "            border-top: 6px solid #2b6cb0;\n" +
               "        }\n" +
               "        h1 {\n" +
               "            color: #1a365d;\n" +
               "            font-family: 'Georgia', serif;\n" +
               "            margin-bottom: 5px;\n" +
               "            font-size: 32px;\n" +
               "        }\n" +
               "        h2 {\n" +
               "            color: #4a5568;\n" +
               "            font-family: 'Courier New', Courier, monospace;\n" +
               "            margin-top: 0;\n" +
               "            font-size: 22px;\n" +
               "            border-bottom: 2px solid #e2e8f0;\n" +
               "            padding-bottom: 15px;\n" +
               "        }\n" +
               "        p {\n" +
               "            font-size: 16px;\n" +
               "            text-align: justify;\n" +
               "            color: #4a5568;\n" +
               "        }\n" +
               "        .highlight {\n" +
               "            color: #2b6cb0;\n" +
               "            font-weight: bold;\n" +
               "        }\n" +
               "        .skills {\n" +
               "            background-color: #ebf8ff;\n" +
               "            padding: 15px;\n" +
               "            border-left: 4px solid #3182ce;\n" +
               "            font-family: 'Verdana', sans-serif;\n" +
               "            font-size: 14px;\n" +
               "            margin-top: 20px;\n" +
               "        }\n" +
               "    </style>\n" +
               "</head>\n" +
               "<body>\n" +
               "    <div class=\"card\">\n" +
               "        <h1>" + fullName + "</h1>\n" +
               "        <h2>Öğrenci No: " + studentNumber + "</h2>\n" +
               "        <p>\n" +
               "            Merhaba! Ben <span class=\"highlight\">" + fullName + "</span>. Yazılım Mühendisliği / Bilgisayar Mühendisliği \n" +
               "            bölümünde lisans eğitimime devam etmekteyim. Yazılım geliştirme süreçlerine, sistem mimarilerine ve \n" +
               "            ağ programlamaya (Socket Programming) özel bir ilgi duyuyorum.\n" +
               "        </p>\n" +
               "        <p>\n" +
               "            Eğitim hayatım boyunca <b>Nesne Yönelimli Programlama (Java)</b>, <b>Veri Yapıları ve Algoritmalar (C)</b> \n" +
               "            ve <b>İlişkisel Veritabanı Tasarımı (SQL)</b> gibi temel mühendislik alanlarında çeşitli akademik projeler geliştirdim. \n" +
               "            Yazılımda temiz kod (Clean Code) ilkelerini ve <i>SOLID</i> tasarım prensiplerini benimseyerek ölçeklenebilir \n" +
               "            uygulamalar inşa etmeyi hedefliyorum.\n" +
               "        </p>\n" +
               "        <div class=\"skills\">\n" +
               "            <strong>İlgi Alanları & Teknolojiler:</strong> Java, C, SQL, Socket Programlama, Nesne Yönelimli Tasarım (OOP), Web Teknolojileri.\n" +
               "        </div>\n" +
               "    </div>\n" +
               "</body>\n" +
               "</html>";
    }
}