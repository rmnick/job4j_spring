package org.chubaka.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProcessingController {

    @RequestMapping("/enter-name")
    public String showInput() {
        return "inputField";
    }

    @RequestMapping("/processing-name")
    public String doProcess() {
        return "helloName";
    }
}
