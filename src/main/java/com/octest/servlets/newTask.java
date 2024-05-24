package com.octest.servlets;

import com.octest.beans.Project;
import com.octest.beans.Task;
import com.octest.dao.taskDao;
import com.octest.dao.taskDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "newTask", value = "/newTask")
public class newTask extends HttpServlet {
    private taskDao taskDAO = new taskDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idProject = Integer.parseInt(request.getParameter("idProject"));
        request.setAttribute("idProject",idProject);
        this.getServletContext().getRequestDispatcher("/WEB-INF/addTask.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idProject = Integer.parseInt(request.getParameter("idProject"));
        String description = request.getParameter("description");
        String startDateStr = request.getParameter("startDate");
        String endDateStr = request.getParameter("endDate");
        String statut = request.getParameter("statut");
        String pictureResponsable = request.getParameter("picture");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(startDateStr, formatter);
        LocalDate endDate = LocalDate.parse(endDateStr, formatter);
        Task task = new Task(description,startDate,endDate,statut,pictureResponsable,idProject);
        try {
            taskDAO.addTask(task);
            request.setAttribute("result","task added successfully");
            response.sendRedirect("/constructionXpert/tasksProject?idProject="+idProject);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
