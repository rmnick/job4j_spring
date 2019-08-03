package ru.job4j.service.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "login")
    private String login;

    @Column(name = "phone")
    private String phone;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Message> messageList;

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return id == user.id
                && name.equals(user.name)
                && login.equals(user.login)
                && phone.equals(user.phone)
                && password.equals(user.password)
                && Objects.equals(messageList, user.messageList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, login, phone, password, messageList);
    }

    @Override
    public String toString() {
        return String.format("User{id : %d, name : %s, login : %s, phone : %s}", this.id, this.name, this.login, this.phone);
    }
}
