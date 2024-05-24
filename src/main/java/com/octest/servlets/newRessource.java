package com.octest.servlets;

import com.octest.beans.Ressource;
import com.octest.beans.Task;
import com.octest.dao.ressourceDao;
import com.octest.dao.ressourceDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "newRessource", value = "/newRessource")
public class newRessource extends HttpServlet {
    private ressourceDao ressourceDAO =new ressourceDaoImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idTask = Integer.parseInt(request.getParameter("idTask"));
        request.setAttribute("idTask",idTask);
        this.getServletContext().getRequestDispatcher("/WEB-INF/addRessources.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idTask = Integer.parseInt(request.getParameter("idTask"));
        String nameRessource = request.getParameter("name");
        String type = request.getParameter("type");
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));
        String supplier = request.getParameter("supplier");
        String pictureRessource = request.getParameter("picture");

        Ressource ressource = new Ressource(nameRessource,type,quantity,supplier,pictureRessource,idTask);
        try {
            ressourceDAO.addRessource(ressource);
            request.setAttribute("result","ressource added successfully");
            response.sendRedirect("/constructionXpert/ressourcesTask?idTask="+idTask);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
