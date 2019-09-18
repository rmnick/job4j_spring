package org.chubaka.chapterone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("swim")
@Scope("prototype")
public class SwimCoach implements ICoach {

    @Autowired
    @Qualifier("heavyBag")
    private IBag bag;

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
}
