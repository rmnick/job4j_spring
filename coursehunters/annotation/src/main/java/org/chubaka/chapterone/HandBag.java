package org.chubaka.chapterone;

import org.springframework.stereotype.Component;

@Component
public class HandBag implements IBag {
    @Override
    public String carry() {
        return "get personal stuff";
    }
}
