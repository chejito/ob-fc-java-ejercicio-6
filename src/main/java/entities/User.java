package entities;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

import java.util.ArrayList;
import java.util.Set;

public class User {

    private static final ArrayList<User> users = new ArrayList<>();

    private Long id;
    private String username;
    private String password;
    private String email;
    private String fullname;
//    Relación
    private Set<Student> students;

    public User() {}

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String username, String password, String email, String fullname) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullname = fullname;
    }

    public User(Long id, String username, String password, String email, String fullname) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullname = fullname;
    }

    /**
     * Método que permite registrar a un usuario con sus datos de usuario (e-mail y contraseña).
     *
     * @param email    String e-mail del usuario.
     * @param password String contraseña del usuario.
     * @return boolean false si el usuario está almacenado en el repositorio, true si es un nuevo usuario.
     */
    public static boolean register(String email, String password) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if (!email.equals("") && !password.equals("")) {
            User storedUser = null;

            for (User user : users) {
                if (user.getEmail().equals(email)) {
                    storedUser = user;
                }
            }

            if (storedUser == null) {
                char[] characters = password.toCharArray();
                String passwordHash = argon2.hash(20, 65536, 1, characters);
                users.add(new User(email, passwordHash));
                return true;
            }
        }
        return false;
    }
    /**
     * Método que permite iniciar sesión a un usuario con sus datos de usuario (e-mail y contraseña).
     *
     * @param email    String e-mail del usuario.
     * @param password String contraseña del usuario.
     * @return int -1 si el e-mail no existe, -2 si la contraseña es incorrecta y 1 si ambos son correctos.
     */
    public static int login(String email, String password) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        User storedUser = null;

        for (User user : users) {
            if (user.getEmail().equals(email)) {
                storedUser = user;
            }
        }
        if (storedUser == null) {
            return -1;
        }

        char[] characters = password.toCharArray();
        String passwordHash = argon2.hash(40, 65536, 1, characters);
        if (!argon2.verify(storedUser.getPassword(), characters)) {
            return -2;
        }
        return 1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", fullname='" + fullname + '\'' +
                '}';
    }
}
