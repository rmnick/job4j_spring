package org.chubaka.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cat")
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name = "person_id")
    private Person person;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "cat_id")
    private List<Flea> fleas;

    public Cat() {

    }

    public Cat(String name) {
        this.name = name;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return String.format("Cat{id = %d, name = %s}", this.id, this.name);
    }
}
