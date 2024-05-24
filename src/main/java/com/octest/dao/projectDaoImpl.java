package com.octest.dao;

import com.octest.beans.Project;
import com.octest.config.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class projectDaoImpl implements projectDao{
    public ArrayList<Project> getAllProject() throws SQLException, ClassNotFoundException {
        ArrayList<Project> listProjects = new ArrayList<Project>();
        String sql="SELECT * FROM project";
        PreparedStatement statement = Connection.getConnection().prepareStatement(sql);
        ResultSet resultat = statement.executeQuery();

        while (resultat.next()) {
            Integer idProject = resultat.getInt("idProject");
            String nameProject = resultat.getString("nameProject");
            String descriptionProject = resultat.getString("descriptionProject");
            LocalDate startDate = resultat.getDate("startDate").toLocalDate();
            LocalDate endDate = resultat.getDate("endDate").toLocalDate();
            Integer budget = resultat.getInt("budget");
            String pictureProject = resultat.getString("pictureProject");

            Project project = new Project(idProject,nameProject,descriptionProject,startDate,endDate,budget,pictureProject);
            listProjects.add(project);

        }
        return listProjects;
    }

    public void addProject(Project project) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO project (nameProject,descriptionProject,startDate,endDate,budget,pictureProject) VALUES (?,?,?,?,?,?)";
        PreparedStatement preparedStatement = Connection.getConnection().prepareStatement(sql);

        preparedStatement.setString(1,project.getNameProject());
        preparedStatement.setString(2,project.getDescriptionProject());
        preparedStatement.setDate(3, Date.valueOf(project.getStartDate()));
        preparedStatement.setDate(4, Date.valueOf(project.getEndDate()));
        preparedStatement.setInt(5,project.getBudget());
        preparedStatement.setString(6,project.getPictureProject());
        preparedStatement.executeUpdate();
    }

    public void updateProject(Project project) throws SQLException, ClassNotFoundException {
        String sql = "update project set nameProject=?,descriptionProject=?,startDate=?,endDate=?,budget=?,pictureProject=? where idProject=?";
        PreparedStatement preparedStatement = Connection.getConnection().prepareStatement(sql);

        preparedStatement.setString(1,project.getNameProject());
        preparedStatement.setString(2,project.getDescriptionProject());
        preparedStatement.setDate(3, Date.valueOf(project.getStartDate()));
        preparedStatement.setDate(4, Date.valueOf(project.getEndDate()));
        preparedStatement.setInt(5,project.getBudget());
        preparedStatement.setString(6,project.getPictureProject());
        preparedStatement.setInt(7,project.getIdProject());
        preparedStatement.executeUpdate();
    }

    public void deleteProject(int idProject) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM ressource WHERE idTask IN (SELECT idTask FROM task WHERE idProject = ?);";
        PreparedStatement preparedStatement = Connection.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1,idProject);
        preparedStatement.executeUpdate();

        sql = "delete from task where idProject=?";
        preparedStatement = Connection.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1,idProject);
        preparedStatement.executeUpdate();

        sql = "delete from project where idProject=?";
        preparedStatement = Connection.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1,idProject);
        preparedStatement.executeUpdate();
    }

    public Project getProjectbyId(int idProject) throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM project where idProject=?";
        PreparedStatement statement = Connection.getConnection().prepareStatement(sql);
        statement.setInt(1,idProject);
        ResultSet resultat = statement.executeQuery();

        while (resultat.next()) {
            String nameProject = resultat.getString("nameProject");
            String descriptionProject = resultat.getString("descriptionProject");
            LocalDate startDate = resultat.getDate("startDate").toLocalDate();
            LocalDate endDate = resultat.getDate("endDate").toLocalDate();
            Integer budget = resultat.getInt("budget");
            String pictureProject = resultat.getString("pictureProject");

            Project project = new Project(idProject,nameProject,descriptionProject,startDate,endDate,budget,pictureProject);
            return project;
        }
        return null;
    }
}
