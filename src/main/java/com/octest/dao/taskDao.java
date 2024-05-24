package com.octest.dao;

import com.octest.beans.Task;

import java.sql.SQLException;
import java.util.ArrayList;

public interface taskDao {
    ArrayList<Task> getTasksByIdProject(int idProject) throws SQLException, ClassNotFoundException;
    void addTask(Task task) throws SQLException, ClassNotFoundException;
    void updateTask(Task task) throws SQLException, ClassNotFoundException;
    void deleteTask(int idTask) throws SQLException, ClassNotFoundException;
    Task gettaskbyId(int idTask) throws SQLException, ClassNotFoundException;
}
