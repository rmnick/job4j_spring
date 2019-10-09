package org.chubaka.entities;

import javax.persistence.*;

@Entity
@Table(name = "info")
public class Info {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "hobby")
    private String hobby;

    @Column(name = "married")
    private boolean married;

    /**
     * for the bidirectional link
     */
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @OneToOne(mappedBy = "info", cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH}
            )
    private Person person;



    public Info() {

    }

    public Info(String hobby, boolean married) {
        this.hobby = hobby;
        this.married = married;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    @Override
    public String toString() {
        return "Info{"
                + "hobby='"
                + hobby
                + System.lineSeparator()
                + ", married="
                + married
                + '}';
    }
}