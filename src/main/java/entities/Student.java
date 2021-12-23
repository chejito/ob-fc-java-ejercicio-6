package entities;

import java.util.Set;

public class Student {

    private Long id;
    private String fullname;
    private String country;
    private String city;
    private String phoneNumber;
    private String email;
    private String modality;
    private Boolean move;
    private String photoUrl;
    private String resumeUrl;
//    Relaciones
    private User user;
    private Set<Tag> tags;


    public Student() {}

    public Student(String fullname, String country, String city, String phoneNumber, String email,
                   String modality, Boolean move, String photoUrl, String resumeUrl) {
        this.fullname = fullname;
        this.country = country;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.modality = modality;
        this.move = move;
        this.photoUrl = photoUrl;
        this.resumeUrl = resumeUrl;
    }

    public Student(Long id, String fullname, String country, String city, String phoneNumber, String email, String modality, Boolean move, String photoUrl, String resumeUrl) {
        this.id = id;
        this.fullname = fullname;
        this.country = country;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.modality = modality;
        this.move = move;
        this.photoUrl = photoUrl;
        this.resumeUrl = resumeUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getModality() {
        return modality;
    }

    public void setModality(String modality) {
        this.modality = modality;
    }

    public Boolean getMove() {
        return move;
    }

    public void setMove(Boolean move) {
        this.move = move;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getResumeUrl() {
        return resumeUrl;
    }

    public void setResumeUrl(String resumeUrl) {
        this.resumeUrl = resumeUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", modality='" + modality + '\'' +
                ", move=" + move +
                ", photoUrl='" + photoUrl + '\'' +
                ", resumeUrl='" + resumeUrl + '\'' +
                '}';
    }
}
