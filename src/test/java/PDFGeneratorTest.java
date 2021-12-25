import entities.Student;
import entities.Tag;
import entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PDFGeneratorTest {

    @BeforeEach
    void init() {


    }

    @Test
    void generate() {
        PDFGenerator generator = new PDFGenerator();

        User user = new User("Chejito", "12345", "chejito@fakemail.com", "Chejito chejito");

        Set<Tag> tags = new HashSet<>(List.of(new Tag("Html/CSS"), new Tag("JS"), new Tag("React")));

        Student student = new Student("Pepito Palotes Pelotero",
                "España",
                "Madrid",
                "566-678-901",
                "pepito@palotes.com",
                "Presencial",
                true,
                null,
                null);
        student.setPhotoUrl("https://cdn.pixabay.com/photo/2015/01/21/19/39/bunny-607097_1280.jpg");
        student.setTags(tags);
        student.setUser(user);

        assertEquals(generator.generate(student), 1);
    }

}