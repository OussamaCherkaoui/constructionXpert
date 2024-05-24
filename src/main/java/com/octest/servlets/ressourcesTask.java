package com.octest.servlets;

import com.octest.dao.projectDao;
import com.octest.dao.projectDaoImpl;
import com.octest.dao.ressourceDao;
import com.octest.dao.ressourceDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ressourcesTask", value = "/ressourcesTask")
public class ressourcesTask extends HttpServlet {
    private ressourceDao ressourceDAO = new ressourceDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int idTask = Integer.parseInt(request.getParameter("idTask"));
            request.setAttribute("idTask", idTask);
            request.setAttribute("ressources", ressourceDAO.getRessourceByIdTask(idTask));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/ressources.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
