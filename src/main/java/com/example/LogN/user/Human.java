package com.example.LogN.user;



import javax.persistence.*;

@Entity
@Table
public class Human {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private long id;
    private String username;
    private String email;
    private String password;
    private Boolean is_admin;

    public Human() {
    }

    public Human(long id, String username, String email, String password, Boolean is_admin) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.is_admin = is_admin;
    }

    public Human(String username, String email, String password, Boolean is_admin) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.is_admin = is_admin;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getIs_admin() {
        return is_admin;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIs_admin(Boolean is_admin) {
        this.is_admin = is_admin;
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", is_admin=" + is_admin +
                '}';
    }
}
