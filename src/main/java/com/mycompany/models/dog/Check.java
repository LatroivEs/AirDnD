/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.models.dog;

import java.sql.Date;

/**
 *
 * @author AJM
 */
public class Check {
    
    private String name;
    private String surname;
    private String email;
    private int Apart_Name_id;
    private Date start_date;
    private String details;
    
    public Check(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getApart_Name_id() {
        return Apart_Name_id;
    }

    public void setApart_Name_id(int Apart_Name_id) {
        this.Apart_Name_id = Apart_Name_id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
    
    
}
