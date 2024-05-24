package com.octest.servlets;

import com.octest.dao.ressourceDao;
import com.octest.dao.ressourceDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "deleteRessource", value = "/deleteRessource")
public class deleteRessource extends HttpServlet {
    private ressourceDao ressourceDAO =new ressourceDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idRessource = Integer.parseInt(request.getParameter("idRessource"));
        Integer idTask = Integer.parseInt(request.getParameter("idTask"));
        try {
            ressourceDAO.deleteRessource(idRessource);
            response.sendRedirect("/constructionXpert/ressourcesTask?idTask="+idTask);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
