package com.octest.dao;

import com.octest.beans.Ressource;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ressourceDao {
    ArrayList<Ressource> getRessourceByIdTask(int idTask) throws SQLException, ClassNotFoundException;
    void addRessource(Ressource ressource) throws SQLException, ClassNotFoundException;
    void updateRessource(Ressource ressource) throws SQLException, ClassNotFoundException;
    void deleteRessource(int idRessource) throws SQLException, ClassNotFoundException;
    Ressource getressourcebyId(int idRessource) throws SQLException, ClassNotFoundException;
}
