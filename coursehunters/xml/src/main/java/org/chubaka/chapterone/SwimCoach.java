package org.chubaka.chapterone;

public class SwimCoach implements ICoach {

    private IBag bag;
    private String name;
    public String email;

    public SwimCoach() {

    }

    @Override
    public String prepare() {
        return bag.carry();
    }

    @Override
    public String work() {
        return "practice swimming";
    }

    //inject dependency in set method
    public void setBag(IBag bag) {
        this.bag = bag;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name + " " + this.email;
    }
}
