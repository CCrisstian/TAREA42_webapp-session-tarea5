package org.CCristian.apiservlet.webapp.session.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/guardar-session")
public class GuardarNombreSessionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");

        if (nombre != null && !nombre.trim().isEmpty()) {
            HttpSession session = req.getSession();
            session.setAttribute("nombre", nombre);
            resp.sendRedirect(req.getContextPath() + "/perfil-usuario");
        }else {
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        }

    }
}
