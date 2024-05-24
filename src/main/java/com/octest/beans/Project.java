package com.octest.beans;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Project {
   private Integer idProject;
   private String nameProject;
   private String descriptionProject;
   private LocalDate startDate;
   private LocalDate endDate;
   private Integer budget;
   private String pictureProject;

    public Project(int idProject, String nameProject, String descriptionProject, LocalDate startDate, LocalDate endDate, int budget, String pictureProject) {
        this.idProject = idProject;
        this.nameProject = nameProject;
        this.descriptionProject = descriptionProject;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
        this.pictureProject = pictureProject;
    }

    public Project(String nameProject, String description, LocalDate startDate, LocalDate endDate, Integer budget, String pictureProject) {
        this.nameProject = nameProject;
        this.descriptionProject = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
        this.pictureProject = pictureProject;
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    public String getNameProject() {
        return nameProject;
    }

    public void setNameProject(String nameProject) {
        this.nameProject = nameProject;
    }

    public String getDescriptionProject() {
        return descriptionProject;
    }

    public void setDescriptionProject(String descriptionProject) {
        this.descriptionProject = descriptionProject;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getPictureProject() {
        return pictureProject;
    }

    public void setPictureProject(String pictureProject) {
        this.pictureProject = pictureProject;
    }

}
