package com.octest.dao;

import com.octest.beans.Task;
import com.octest.config.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class taskDaoImpl implements taskDao{
    public ArrayList<Task> getTasksByIdProject(int idProject) throws SQLException, ClassNotFoundException {
        ArrayList<Task> listTasks = new ArrayList<Task>();
        String sql="SELECT * FROM task where idProject=?";
        PreparedStatement statement = Connection.getConnection().prepareStatement(sql);
        statement.setInt(1,idProject);
        ResultSet resultat = statement.executeQuery();

        while (resultat.next()) {
            Integer idTask = resultat.getInt("idTask");
            String descriptionTache = resultat.getString("descriptionTache");
            LocalDate startDate = resultat.getDate("startDate").toLocalDate();
            LocalDate endDate = resultat.getDate("endDate").toLocalDate();
            String statut = resultat.getString("statut");
            String pictureResponsable = resultat.getString("pictureResponsable");

            Task task = new Task(idTask,descriptionTache,startDate,endDate,statut,pictureResponsable,idProject);
            listTasks.add(task);
        }
        return listTasks;
    }

    public void addTask(Task task) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO task (descriptionTache,startDate,endDate,statut,pictureResponsable,idProject) VALUES (?,?,?,?,?,?)";
        PreparedStatement preparedStatement = Connection.getConnection().prepareStatement(sql);

        preparedStatement.setString(1,task.getDescriptionTache());
        preparedStatement.setDate(2, java.sql.Date.valueOf(task.getStartDate()));
        preparedStatement.setDate(3, java.sql.Date.valueOf(task.getEndDate()));
        preparedStatement.setString(4,task.getStatut());
        preparedStatement.setString(5,task.getPictureResponsable());
        preparedStatement.setInt(6,task.getIdProject());
        preparedStatement.executeUpdate();
    }

    public void updateTask(Task task) throws SQLException, ClassNotFoundException {
        String sql = "update task set descriptionTache=?,startDate=?,endDate=?,statut=?,pictureResponsable=?,idProject=? where idTask=?) VALUES (?,?,?,?,?,?)";
        PreparedStatement preparedStatement = Connection.getConnection().prepareStatement(sql);

        preparedStatement.setString(1,task.getDescriptionTache());
        preparedStatement.setDate(2, java.sql.Date.valueOf(task.getStartDate()));
        preparedStatement.setDate(3, java.sql.Date.valueOf(task.getEndDate()));
        preparedStatement.setString(4,task.getStatut());
        preparedStatement.setString(5,task.getPictureResponsable());
        preparedStatement.setInt(6,task.getIdProject());
        preparedStatement.setInt(7,task.getIdTask());
        preparedStatement.executeUpdate();
    }

    public void deleteTask(int idTask) throws SQLException, ClassNotFoundException {
        String sql = "delete from task where idTask=?";
        PreparedStatement preparedStatement = Connection.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1,idTask);
        preparedStatement.executeUpdate();
    }

    public Task gettaskbyId(int idTask) throws SQLException, ClassNotFoundException {
        ArrayList<Task> listTasks = new ArrayList<Task>();
        String sql="SELECT * FROM task where idTask=?";
        PreparedStatement statement = Connection.getConnection().prepareStatement(sql);
        statement.setInt(1,idTask);
        ResultSet resultat = statement.executeQuery();

        while (resultat.next()) {
            String descriptionTache = resultat.getString("descriptionTache");
            LocalDate startDate = resultat.getDate("startDate").toLocalDate();
            LocalDate endDate = resultat.getDate("endDate").toLocalDate();
            String statut = resultat.getString("statut");
            String pictureResponsable = resultat.getString("pictureResponsable");
            Integer idProject = resultat.getInt("idProject");

            Task task = new Task(idTask,descriptionTache,startDate,endDate,statut,pictureResponsable,idProject);
            return task;
        }
        return null;
    }
}
