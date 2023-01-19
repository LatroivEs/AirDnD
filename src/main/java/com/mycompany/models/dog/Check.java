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
public class Check{
    
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String apart_name_id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getApart_name_id() {
        return apart_name_id;
    }

    public void setApart_name_id(String apart_name_id) {
        this.apart_name_id = apart_name_id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }  
}
