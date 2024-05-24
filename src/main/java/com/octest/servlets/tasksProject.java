package com.octest.servlets;

import com.octest.dao.projectDao;
import com.octest.dao.projectDaoImpl;
import com.octest.dao.taskDao;
import com.octest.dao.taskDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "tasksProject", value = "/tasksProject")
public class tasksProject extends HttpServlet {
    private taskDao taskDAO = new taskDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int idProject = Integer.parseInt(request.getParameter("idProject"));
            request.setAttribute("tasks", taskDAO.getTasksByIdProject(idProject));
            request.setAttribute("idProject",idProject);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/tasks.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
