package org.chubaka.javacode;

import org.springframework.beans.factory.annotation.Value;

public class RunCoach implements ICoach {

    private IBag bag;
    @Value("${nameOne}")
    private String name;

    public RunCoach() {
    }

    public RunCoach(IBag bag) {
        this.bag = bag;
    }

    @Override
    public void warmUp() {
        System.out.println("Running for warm up");
    }

    @Override
    public String prepare() {
        return bag.carry();
    }

    @Override
    public String work() {
        return "practice running";
    }

    @Override
    public void endUp() {
        System.out.println("Closing training");
    }

    @Override
    public String toString() {
        return String.format("runCoach " + this.name);
    }

}
