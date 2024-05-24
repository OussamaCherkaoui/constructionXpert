package com.octest.servlets;

import com.octest.dao.taskDao;
import com.octest.dao.taskDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "deleteTask", value = "/deleteTask")
public class deleteTask extends HttpServlet {
    private taskDao taskDAO = new taskDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idTask = Integer.parseInt(request.getParameter("idTask"));
        Integer idProject = Integer.parseInt(request.getParameter("idProject"));
        try {
            taskDAO.deleteTask(idTask);
            response.sendRedirect("/constructionXpert/tasksProject?idProject="+idProject);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
