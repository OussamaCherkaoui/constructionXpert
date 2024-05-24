package com.octest.dao;

import com.octest.beans.Project;

import java.sql.SQLException;
import java.util.ArrayList;

public interface projectDao {
    ArrayList<Project> getAllProject() throws SQLException, ClassNotFoundException;
    void addProject(Project project) throws SQLException, ClassNotFoundException;
    void updateProject(Project project) throws SQLException, ClassNotFoundException;
    void deleteProject(int idProject) throws SQLException, ClassNotFoundException;
    Project getProjectbyId(int idProject) throws SQLException, ClassNotFoundException;
}
