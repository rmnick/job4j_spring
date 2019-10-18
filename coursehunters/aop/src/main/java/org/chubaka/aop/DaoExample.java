package org.chubaka.aop;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DaoExample {

    public void doSomethingUseful() {
        System.out.println("some work...");
    }

    public void doSomethingMore() {
        System.out.println("some additional work");
    }

    public void doSomethingWithArguments(String str, boolean b) {
        System.out.println("args");
    }

    public List<String> getSomeStrings() {
        List<String> result = new ArrayList<>();
        result.add("first");
        result.add("second");
        return result;
    }

    public void doException(boolean b) {
        if (b == true) {
            throw new RuntimeException("hey from doException");
        }
    }
}
