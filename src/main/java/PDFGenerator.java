import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import entities.Student;
import entities.Tag;

import java.io.FileOutputStream;
import java.util.Set;

public class PDFGenerator {
    private final Document document = new Document(PageSize.A4, 100f, 50f, 50f, 50f);


    public PDFGenerator() {}

    public int generate(Student student) {
        String fullName = student.getFullname();
        String country = student.getCountry();
        String city = student.getCity();
        String phoneNumber = student.getPhoneNumber();
        String email = student.getEmail();
        String modality = student.getModality();
        Boolean move = student.getMove();
        String imageUrl = student.getPhotoUrl();
        String userName = student.getUser().getUsername();
        Set<Tag> tags = student.getTags();

        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA, 20, Font.BOLD);
        Font headerFont = FontFactory.getFont(FontFactory.HELVETICA, 15, Font.BOLD);
        Font paragraphHeaderFont = FontFactory.getFont(FontFactory.HELVETICA, 13, Font.ITALIC);
        Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL);

        try {
            PdfWriter writer = PdfWriter.getInstance(document,
                    new FileOutputStream(String.format("src/main/resources/resumes/CV_%s.pdf", fullName)));
            document.open();

            document.addTitle(String.format("CV_%s", fullName));
            document.addAuthor(userName);
            document.addCreator("OB-FC-PDF-Generator");
            document.addCreationDate();
            document.addSubject(String.format("Currículum Vitae del Candidato \"%s\"", fullName));

            document.add(new Paragraph(fullName, titleFont));

            Image image = Image.getInstance(imageUrl);
            image.scaleAbsolute(150, 150);
            document.add(image);

            document.add(new Paragraph("Información personal", headerFont));
            document.add(new Paragraph("País", paragraphHeaderFont));
            document.add(new Paragraph(country, paragraphFont));
            document.add(new Paragraph("Ciudad", paragraphHeaderFont));
            document.add(new Paragraph(city, paragraphFont));
            document.add(new Paragraph("Teléfono", paragraphHeaderFont));
            document.add(new Paragraph(phoneNumber,paragraphFont));
            document.add(new Paragraph("E-mail", paragraphHeaderFont));
            document.add(new Paragraph(email, paragraphFont));
            document.add(new Paragraph("Modalidad", paragraphHeaderFont));
            document.add(new Paragraph(modality, paragraphFont));
            document.add(new Paragraph("Posibilidad de traslado", paragraphHeaderFont));
            if (move) {
                document.add(new Paragraph("Sí", paragraphFont));
            } else {
                document.add(new Paragraph("No", paragraphFont));
            }

            document.add(new Paragraph("Habilidades", headerFont));
            List skillsList = new List(List.UNORDERED);
            tags.forEach(x -> {
                ListItem item = new ListItem();
                item.add(new Paragraph(x.getName(), paragraphFont));
                skillsList.add(item);
            });
            document.add(skillsList);

            document.close();
            writer.close();
            return 1;
        } catch (Exception e ) {
            System.err.printf("\nError: %s\n", e.getMessage());
            return -1;
        }
    }
}
