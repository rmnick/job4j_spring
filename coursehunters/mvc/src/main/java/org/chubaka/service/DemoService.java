package org.chubaka.service;

import org.springframework.stereotype.Component;

@Component
public class DemoService implements IService {

    @Override
    public String doCaps(String str) {
        return str.toUpperCase();
    }

    @Override
    public String doLower(String str) {
        return str.toLowerCase();
    }
}
