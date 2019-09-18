package org.chubaka.chapterone;

import org.springframework.stereotype.Component;

@Component
public class HeavyBag implements IBag {
    @Override
    public String carry() {
        return "get sport equipment";
    }
}
