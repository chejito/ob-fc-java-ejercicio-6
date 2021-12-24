import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import entities.Student;

import java.io.FileOutputStream;

public class PDFGenerator {
    private final Document document = new Document();

    public PDFGenerator() {}

    public int generate(Student student) {
        String fullName = student.getFullname();
        String userName = student.getUser().getUsername();

        try {
            PdfWriter writer = PdfWriter.getInstance(document,
                    new FileOutputStream(String.format("src/main/resources/resumes/CV_%s.pdf", fullName)));
            document.open();

            document.addTitle(String.format("CV_%s", fullName));
            document.addAuthor(userName);
            document.addCreator("OB-FC-PDF-Generator");
            document.addCreationDate();
            document.addSubject(String.format("Currículum Vitae del Candidato \"%s\"", fullName));


//            String imageUrl = "https://cdn.pixabay.com/photo/2015/01/21/19/39/bunny-607097_1280.jpg";
//            Image image = Image.getInstance(imageUrl);
//            image.setAbsolutePosition(50f, 650f);
//            image.scaleAbsolute(150, 150);
//            document.add(image);
//            document.add(new Paragraph("Fotografía de perfil"));

            document.add(new Paragraph("Hola desde el PDF generado desde Java"));

            document.close();
            writer.close();
            return 1;
        } catch (Exception e ) {
            System.err.printf("\nError: %s\n", e.getMessage());
            return -1;
        }
    }
}
