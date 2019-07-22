package ru.job4j.controllers;

import ru.job4j.service.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Users extends HttpServlet {

    private Map<Integer, User> map = new ConcurrentHashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setId(1);
        user.setLogin("user");
        user.setName("user");
        user.setPhone("79068510863");
        map.put(user.getId(), user);
        req.setAttribute("users", map);
        req.getRequestDispatcher("/WEB-INF/view/users.jsp").forward(req, resp);
    }
}
