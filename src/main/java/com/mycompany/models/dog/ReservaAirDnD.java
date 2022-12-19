/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.models.dog;

import java.util.Date;

/**
 *
 * @author AJM
 */
public class ReservaAirDnD {
    
    private int reserve_table_id;
    private int apart_name_id;
    private int id_client;
    private String reserve_status_id;
    private float total;
    private float paid;
    private Date start_date;
    private Date finish_Date;
    private String details;
    
    public ReservaAirDnD(){
    }

    public int getReserve_table_id() {
        return reserve_table_id;
    }

    public void setReserve_table_id(int reserve_table_id) {
        this.reserve_table_id = reserve_table_id;
    }

    public int getApart_name_id() {
        return apart_name_id;
    }

    public void setApart_name_id(int apart_name_id) {
        this.apart_name_id = apart_name_id;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getReserve_status_id() {
        return reserve_status_id;
    }

    public void setReserve_status_id(String reserve_status_id) {
        this.reserve_status_id = reserve_status_id;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getPaid() {
        return paid;
    }

    public void setPaid(float paid) {
        this.paid = paid;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getFinish_Date() {
        return finish_Date;
    }

    public void setFinish_Date(Date finish_Date) {
        this.finish_Date = finish_Date;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
    
}
