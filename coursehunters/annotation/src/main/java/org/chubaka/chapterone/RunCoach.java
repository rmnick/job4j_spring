package org.chubaka.chapterone;

import org.springframework.stereotype.Component;

@Component("run")
public class RunCoach implements ICoach {

    private IBag bag;
    private String name;

    public RunCoach(IBag bag, String name) {
        this.bag = bag;
        this.name = name;
    }

    @Override
    public String prepare() {
        return bag.carry();
    }

    @Override
    public String work() {
        return "practice running";
    }

    public String getName() {
        return this.name;
    }
}
