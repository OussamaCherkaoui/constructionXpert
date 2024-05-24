package com.octest.servlets;

import com.octest.beans.Ressource;
import com.octest.dao.ressourceDao;
import com.octest.dao.ressourceDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "editRessource", value = "/editRessource")
public class editRessource extends HttpServlet {
    private ressourceDao ressourceDAO =new ressourceDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idRessource = Integer.parseInt(request.getParameter("idRessource"));
        Integer idTask = Integer.parseInt(request.getParameter("idTask"));
        try {
            request.setAttribute("idRessource",idRessource);
            request.setAttribute("idTask",idTask);
            request.setAttribute("ressource", ressourceDAO.getressourcebyId(idRessource));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/editRessource.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idTask = Integer.parseInt(request.getParameter("idTask"));
        Integer idRessource = Integer.parseInt(request.getParameter("idRessource"));
        String nameRessource = request.getParameter("name");
        String type = request.getParameter("type");
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));
        String supplier = request.getParameter("supplier");
        String pictureRessource = request.getParameter("picture");

        Ressource ressource = new Ressource(idRessource,nameRessource,type,quantity,supplier,pictureRessource);
        try {
            ressourceDAO.updateRessource(ressource);
            request.setAttribute("result","ressource updated successfully");
            response.sendRedirect("/constructionXpert/ressourcesTask?idTask="+idTask);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
