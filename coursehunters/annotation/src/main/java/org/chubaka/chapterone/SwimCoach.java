package org.chubaka.chapterone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("swim")
@Scope("prototype")
public class SwimCoach implements ICoach {

    @Autowired
    @Qualifier("heavyBag")
    private IBag bag;
    @Value("Vasya")
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
