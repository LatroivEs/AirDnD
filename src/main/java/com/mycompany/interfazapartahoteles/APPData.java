/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interfazapartahoteles;

import com.mycompany.models.dog.Client;
import com.mycompany.models.dog.ReservaAirDnD;
import java.net.URL;
import javafx.scene.Parent;

/**
 *
 * @author AJM
 */
public class APPData {
    
    private static APPData me;
    private static URL screen;
    
    private static Client cl;
    private static ReservaAirDnD rairddnd;
    
    private String fxmlname;
       
    public static APPData getAPPData(){
    
        if(me == null){
            me = new APPData();            
        }       
        return me;
    }
    
    private APPData(){
        
    }
    
    public String getInfo(){
        if(fxmlname == null){
            return "";
        }
        return fxmlname;
    }
    
    public void setInfo(String newfxmlname){
        fxmlname = newfxmlname;
    }
    public static Client getClient(){
        return cl;
    }
    
    public static void setClient(Client cliente){
        cl = cliente;
    }
    
    public static ReservaAirDnD getReservaAirDnD(){
        return rairddnd;
    }
    
    public static void setReservaAirDnD(ReservaAirDnD reserva){
        rairddnd = reserva;
    }
    
    public static URL getHelp(){
        if(screen == null){
           screen = APPData.class.getResource("Help.fxml"); 
        }
        return screen;
    }
    
}
