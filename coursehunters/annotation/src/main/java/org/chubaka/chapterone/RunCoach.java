package org.chubaka.chapterone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("singleton")
public class RunCoach implements ICoach {

    @Autowired
    @Qualifier("handBag")
    private IBag bag;

    public RunCoach() {
    }

    @PostConstruct
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

    @PreDestroy
    @Override
    public void endUp() {
        System.out.println("Closing training");
    }

}
