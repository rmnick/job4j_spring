package ru.job4j.item;


public class User {
    private int id;
    private String name;

    public User() {

    }

    public User(final int id) {
        this.id = id;
    }

    public User(final String name) {
        this.name = name;
    }

    public User(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return this.id == user.getId() && this.name.equals(user.getName());
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + Integer.valueOf(id).hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("User{id : %d; name : %s}", this.id, this.name);
    }


}
