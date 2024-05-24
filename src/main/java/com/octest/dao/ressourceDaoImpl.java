package com.octest.dao;

import com.octest.beans.Ressource;
import com.octest.config.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ressourceDaoImpl implements ressourceDao{
    public ArrayList<Ressource> getRessourceByIdTask(int idTask) throws SQLException, ClassNotFoundException {
        ArrayList<Ressource> listRessources = new ArrayList<Ressource>();
        String sql="SELECT * FROM ressource where idTask=?";
        PreparedStatement statement = Connection.getConnection().prepareStatement(sql);
        statement.setInt(1,idTask);
        ResultSet resultat = statement.executeQuery();

        while (resultat.next()) {
            Integer idRessource = resultat.getInt("idRessource");
            String nameRessource = resultat.getString("nameRessource");
            String type = resultat.getString("type");
            Integer quantity = resultat.getInt("quantity");
            String supplier = resultat.getString("supplier");
            String pictureRessource = resultat.getString("pictureRessource");

            Ressource ressource = new Ressource(idRessource,nameRessource,type,quantity,supplier,pictureRessource,idTask);
            listRessources.add(ressource);
        }
        return listRessources;
    }

    public void addRessource(Ressource ressource) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO ressource (idRessource,nameRessource,type,quantity,supplier,pictureRessource,idTask) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = Connection.getConnection().prepareStatement(sql);

        preparedStatement.setInt(1,ressource.getIdRessource());
        preparedStatement.setString(2,ressource.getNameRessource());
        preparedStatement.setString(3,ressource.getType());
        preparedStatement.setInt(4,ressource.getQuantity());
        preparedStatement.setString(5,ressource.getSupplier());
        preparedStatement.setString(6,ressource.getPictureRessource());
        preparedStatement.setInt(7,ressource.getIdTask());
        preparedStatement.executeUpdate();
    }

    public void updateRessource(Ressource ressource) throws SQLException, ClassNotFoundException {
        String sql = "update ressource set nameRessource=?,type=?,quantity=?,supplier=?,pictureRessource=?,idTask=? where idRessource=?";
        PreparedStatement preparedStatement = Connection.getConnection().prepareStatement(sql);

        preparedStatement.setString(1,ressource.getNameRessource());
        preparedStatement.setString(2,ressource.getType());
        preparedStatement.setInt(3,ressource.getQuantity());
        preparedStatement.setString(4,ressource.getSupplier());
        preparedStatement.setString(5,ressource.getPictureRessource());
        preparedStatement.setInt(6,ressource.getIdTask());
        preparedStatement.setInt(7,ressource.getIdRessource());
        preparedStatement.executeUpdate();
    }

    public void deleteRessource(int idRessource) throws SQLException, ClassNotFoundException {
        String sql = "delete from ressource where idRessource=?";
        PreparedStatement preparedStatement = Connection.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1,idRessource);
        preparedStatement.executeUpdate();
    }

    public Ressource getressourcebyId(int idRessource) throws SQLException, ClassNotFoundException {
        ArrayList<Ressource> listRessources = new ArrayList<Ressource>();
        String sql="SELECT * FROM ressource where idRessource=?";
        PreparedStatement statement = Connection.getConnection().prepareStatement(sql);
        statement.setInt(1,idRessource);
        ResultSet resultat = statement.executeQuery();

        while (resultat.next()) {
            String nameRessource = resultat.getString("nameRessource");
            String type = resultat.getString("type");
            Integer quantity = resultat.getInt("quantity");
            String supplier = resultat.getString("supplier");
            String pictureRessource = resultat.getString("pictureRessource");
            Integer idTask = resultat.getInt("idTask");

            Ressource ressource = new Ressource(idRessource,nameRessource,type,quantity,supplier,pictureRessource,idTask);
            return ressource;
        }
        return null;
    }
}
