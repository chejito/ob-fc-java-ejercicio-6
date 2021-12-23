package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void register() {

        assertAll(
                () -> assertTrue(User.register("user1@user.com", "12345")),
                () -> assertFalse(User.register("user1@user.com", "dogandcat")),
                () -> assertFalse(User.register("", "mytaylorisrich")),
                () -> assertFalse(User.register("user4@user.com", "")),
                () -> assertFalse(User.register("", ""))
        );
    }

    @Test
    void login() {

        String[][] users = {
                {"user6@user.com", "12345"},
                {"user7@user.com", "dogandcat"},
                {"user8@user.com", "mytaylorisrich"},
                {"user9@user.com", "01012000"},
                {"user10@user.com", "imbored"}
        };

        for (String[] user : users) {
            User.register(user[0], user[1]);
        }

        assertAll(
                () ->assertEquals(User.login("user6@user.com", "12345"), 1),
                () -> assertEquals(User.login("user7@user.com", "catandmouse"), -2),
                () -> assertEquals(User.login("user18@user.com", "mytaylorisrich"), -1),
                () -> assertEquals(User.login("", "01012000"), -1),
                () -> assertEquals(User.login("user10@user.com", ""), -2)
        );
    }
}