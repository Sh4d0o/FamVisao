package com.shadoapps.famvisao;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Event {
    private static int EVENT_ID = 0;
    private int id;
    private String title, description, responsableEntity, nature;
    private String tipification;
    private Local local;
    private String startDate, endDate, deadline;

    public Event() {
        this.id = ++EVENT_ID;
        this.title = "";
        this.description = "";
        this.responsableEntity = "";
        this.nature = "";
        this.tipification = "";
        this.local = new Local();
        this.startDate = "";
        this.endDate = "";
        this.deadline = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResponsableEntity() {
        return responsableEntity;
    }

    public void setResponsableEntity(String responsableEntity) {
        this.responsableEntity = responsableEntity;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getTipification() {
        return tipification;
    }

    public void setTipification(String tipification) {
        this.tipification = tipification;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    @Override
    public boolean equals(Object e){
        if(e == this) return true;
        if(e == null) return false;
        if(this.getClass() != e.getClass()) return false;
        Event s = (Event) e;
        return(s.getTitle() == this.getTitle() );
    }


}
