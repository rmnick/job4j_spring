package ru.job4j.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import ru.job4j.service.IService;
import ru.job4j.service.entities.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/enter")
public class EnterController {

    @Autowired
    @Qualifier("userService")
    private IService userService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView enter(HttpServletRequest request, RedirectAttributes attributes) {
        User user = new User();
        user.setLogin(request.getParameter("login"));
        user.setPassword(request.getParameter("password"));
        ModelAndView mv = new ModelAndView("redirect:/message");
        if (this.userService.check(user)) {
            HttpSession session = request.getSession();
            session.setAttribute("login", user.getLogin());
        } else {
            attributes.addFlashAttribute("text", "wrong login or password");
        }
        return mv;
    }
}
