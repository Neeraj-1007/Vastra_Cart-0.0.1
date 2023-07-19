package com.vastracart.login.Entity;


import javax.persistence.*;

@Entity
@Table(name="Login")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name="userName")
    private String userName;

    @Column(name="password")
    private String password;

    public Login(){
    }

    public Login(String userName, String pasword) {
        this.userName = userName;
        this.password = pasword;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", pasword='" + password + '\'' +
                '}';
    }
}
