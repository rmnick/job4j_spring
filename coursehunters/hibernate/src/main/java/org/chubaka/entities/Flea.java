package org.chubaka.entities;

import javax.persistence.*;

@Entity
@Table(name = "flea")
public class Flea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "alias")
    private String alias;

    public Flea() {

    }

    public Flea(String alias) {
        this.alias = alias;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Override
    public String toString() {
        return String.format("Flea{id = %d, alias = %s}", this.id, this.alias);
    }
}
