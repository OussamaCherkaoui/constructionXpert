package com.octest.beans;

import java.util.Date;

public class Ressource {

    private Integer idRessource;
    private String nameRessource;
    private String type;
    private Integer quantity;
    private String supplier;
    private String pictureRessource;
    private Integer idTask;


    public Ressource(int idRessource, String nameRessource, String type, int quantity, String supplier, String pictureRessource, int idTask) {
        this.idRessource = idRessource;
        this.nameRessource = nameRessource;
        this.type = type;
        this.quantity = quantity;
        this.supplier = supplier;
        this.pictureRessource = pictureRessource;
        this.idTask = idTask;
    }

    public Ressource(String nameRessource, String type, Integer quantity, String supplier, String pictureRessource, Integer idTask) {
        this.nameRessource = nameRessource;
        this.type = type;
        this.quantity = quantity;
        this.supplier = supplier;
        this.pictureRessource = pictureRessource;
        this.idTask = idTask;
    }

    public Ressource(Integer idRessource, String nameRessource, String type, Integer quantity, String supplier, String pictureRessource) {
        this.idRessource = idRessource;
        this.nameRessource = nameRessource;
        this.type = type;
        this.quantity = quantity;
        this.supplier = supplier;
        this.pictureRessource = pictureRessource;
    }

    public int getIdRessource() {
        return idRessource;
    }

    public void setIdRessource(int idRessource) {
        this.idRessource = idRessource;
    }

    public String getNameRessource() {
        return nameRessource;
    }

    public void setNameRessource(String nameRessource) {
        this.nameRessource = nameRessource;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getPictureRessource() {
        return pictureRessource;
    }

    public void setPictureRessource(String pictureRessource) {
        this.pictureRessource = pictureRessource;
    }

    public int getIdTask() {
        return idTask;
    }

    public void setIdTask(int idTask) {
        this.idTask = idTask;
    }

}
