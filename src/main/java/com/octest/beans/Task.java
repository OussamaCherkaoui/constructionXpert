package com.octest.beans;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class Task {
    private int idTask;
    private String descriptionTache;
    private LocalDate startDate;
    private LocalDate endDate;
    private String statut;
    private String pictureResponsable;
    private int idProject;


    public Task(int idTask, String descriptionTache, LocalDate startDate, LocalDate endDate, String statut, String pictureResponsable, int idProject) {
        this.idTask = idTask;
        this.descriptionTache = descriptionTache;
        this.startDate = startDate;
        this.endDate = endDate;
        this.statut = statut;
        this.pictureResponsable = pictureResponsable;
        this.idProject = idProject;
    }



    public int getIdTask() {
        return idTask;
    }

    public void setIdTask(int idTask) {
        this.idTask = idTask;
    }

    public String getDescriptionTache() {
        return descriptionTache;
    }

    public void setDescriptionTache(String descriptionTache) {
        this.descriptionTache = descriptionTache;
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

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getPictureResponsable() {
        return pictureResponsable;
    }

    public void setPictureResponsable(String pictureResponsable) {
        this.pictureResponsable = pictureResponsable;
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

}
