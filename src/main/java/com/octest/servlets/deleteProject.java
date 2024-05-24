package com.octest.servlets;

import com.octest.dao.projectDao;
import com.octest.dao.projectDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "deleteProject", value = "/deleteProject")
public class deleteProject extends HttpServlet {
    private projectDao projectDAO = new projectDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idProject = Integer.parseInt(request.getParameter("idProject"));
        try {
            projectDAO.deleteProject(idProject);
            response.sendRedirect("/constructionXpert/ourProjects");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
