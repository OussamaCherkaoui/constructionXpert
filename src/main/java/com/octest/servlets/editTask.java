package com.octest.servlets;

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

@WebServlet(name = "editTask", value = "/editTask")
public class editTask extends HttpServlet {
    private taskDao taskDAO = new taskDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idTask = Integer.parseInt(request.getParameter("idTask"));
        Integer idProject = Integer.parseInt(request.getParameter("idProject"));
        try {
            request.setAttribute("idTask",idTask);
            request.setAttribute("idProject",idProject);
            request.setAttribute("task", taskDAO.gettaskbyId(idTask));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/editTask.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idTask = Integer.parseInt(request.getParameter("idTask"));
        Integer idProject = Integer.parseInt(request.getParameter("idProject"));
        String description = request.getParameter("description");
        String startDateStr = request.getParameter("startDate");
        String endDateStr = request.getParameter("endDate");
        String statut = request.getParameter("statut");
        String pictureResponsable = request.getParameter("picture");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(startDateStr, formatter);
        LocalDate endDate = LocalDate.parse(endDateStr, formatter);
        Task task = new Task(idTask,description,startDate,endDate,statut,pictureResponsable);
        try {
            taskDAO.updateTask(task);
            request.setAttribute("result","task updated successfully");
            response.sendRedirect("/constructionXpert/tasksProject?idProject="+idProject);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
