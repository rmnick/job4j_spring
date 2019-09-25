package org.chubaka.controllers;

import org.chubaka.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/processing")
public class ProcessingController {

    @Autowired
    @Qualifier("demoService")
    private IService service;

    @RequestMapping("/enter-name")
    public String showInput() {
        return "inputField";
    }

    @RequestMapping("/processing-name")
    public String doProcess() {
        return "helloName";
    }

    //get data from request
    @RequestMapping("/processing-caps-name")
    public String doCapsProcessing(HttpServletRequest request, Model model) {
        String name = service.doCaps(request.getParameter("capsName"));
        model.addAttribute("nameCaps", name);
        return "helloName";
    }

    //with annotation requestParam
    @RequestMapping("/processing-lower-name")
    public String doLower(@RequestParam("lowerName") String str, Model model) {
        String name = service.doLower(str);
        model.addAttribute("lowerName", name);
        return "helloName";
    }
}
