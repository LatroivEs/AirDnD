/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interfazapartahoteles;

/**
 *
 * @author AJM
 */
public class APPData {
    
    private static APPData me;
    
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
    
}
