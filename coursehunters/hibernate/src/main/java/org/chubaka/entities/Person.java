package org.chubaka.entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "info_id")
    private Info info;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person",
            cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    private List<Cat> cats;

    public Person() {

    }

    public Person(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<Cat> getCats() {
        return cats;
    }

    public void setCats(List<Cat> cats) {
        this.cats = cats;
    }

    //bond two entities (bidirectional link)
    public void addCat(Cat cat) {
        if (cats == null) {
            cats = new ArrayList<>();
        }
        cat.setPerson(this);
        cats.add(cat);
    }

    @Override
    public String toString() {
        return String.format("Person %d, %s, %s", this.id, this.firstName, this.lastName);
    }
}
