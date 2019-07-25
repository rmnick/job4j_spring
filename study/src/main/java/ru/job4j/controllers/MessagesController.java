package ru.job4j.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.job4j.service.IService;
import ru.job4j.service.entities.Message;
import ru.job4j.service.MessageService;

import java.util.List;

@Controller
public class MessagesController {
    private final static Logger LOG = Logger.getLogger(MessagesController.class.getName());
    private IService messageService = MessageService.getInstance();

//    @Autowired
//    public MessagesController(IService service) {
//        this.messageService = service;
//    }


    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public String showMessages(ModelMap model) {
        List<Message> messages = messageService.getAll();
        model.addAttribute("messages", messages);
        return "messages";
    }
}
