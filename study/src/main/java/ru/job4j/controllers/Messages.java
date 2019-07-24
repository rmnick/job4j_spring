package ru.job4j.controllers;

import ru.job4j.service.entities.Message;
import ru.job4j.service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Messages extends HttpServlet {
    private MessageService messageService = MessageService.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Message> messages = messageService.getAll();
        req.setAttribute("messages", messages);
        req.getRequestDispatcher("/WEB-INF/view/users.jsp").forward(req, resp);
    }
}
