package org.chubaka.javacode;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements ICoach {

    @Autowired
    @Qualifier("heavyBag")
    private IBag bag;
    @Value("${nameTwo}")
    private String name;

    public SwimCoach() {
    }

    @Override
    public void warmUp() {

    }

    @Override
    public String prepare() {
        return bag.carry();
    }

    @Override
    public String work() {
        return "practice swimming";
    }

    @Override
    public void endUp() {
    }

    @Override
    public String toString() {
        return String.format("swimCoach " + this.name);
    }
}
