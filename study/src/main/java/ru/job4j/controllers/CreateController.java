package ru.job4j.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.job4j.service.IService;
import ru.job4j.service.entities.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping(value = "/create")
public class CreateController {

    @Autowired
    @Qualifier("userService")
    private IService service;

    @RequestMapping(method = RequestMethod.GET)
    public String showCreateView() {
        return "create";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView createUser(HttpServletRequest request) {
        User user = new User();
        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));
        user.setLogin(request.getParameter("login"));
        user.setPhone(request.getParameter("phone"));
        if (this.service.checkTwo(user)) {
            service.add(user);
            HttpSession session = request.getSession();
            session.setAttribute("login", user.getLogin());
            return new ModelAndView("redirect:/message");
        } else {
            return new ModelAndView("/create").addObject("text", "phone or login is already exist");
        }
    }

}
