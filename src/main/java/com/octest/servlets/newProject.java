package com.octest.servlets;

import com.octest.beans.Project;
import com.octest.dao.projectDao;
import com.octest.dao.projectDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@WebServlet(name = "newProject", value = "/newProject")
public class newProject extends HttpServlet {
    private projectDao projectDAO = new projectDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/addProject.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameProject = request.getParameter("name");
        String description = request.getParameter("description");
        String startDateStr = request.getParameter("startDate");
        String endDateStr = request.getParameter("endDate");
        Integer budget = Integer.parseInt(request.getParameter("budget"));
        String pictureProject = request.getParameter("picture");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(startDateStr, formatter);
        LocalDate endDate = LocalDate.parse(endDateStr, formatter);
        Project project = new Project(nameProject,description,startDate,endDate,budget,pictureProject);
        try {
            projectDAO.addProject(project);
            request.setAttribute("result","project added successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/addProject.jsp").forward(request, response);
    }
}
