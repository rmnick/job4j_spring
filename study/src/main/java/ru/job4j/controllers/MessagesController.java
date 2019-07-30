package ru.job4j.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.job4j.service.IService;
import ru.job4j.service.entities.Message;

import java.util.List;

@Controller
@RequestMapping(value = "/message")
public class MessagesController {
    private final static Logger LOG = Logger.getLogger(MessagesController.class.getName());

    @Autowired
    @Qualifier ("messageService")
    private IService messageService;


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showMessages() {
        List<Message> messages = messageService.getAll();
        return new ModelAndView("messages", "messages", messages);
    }
}
