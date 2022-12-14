/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.conAPI;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author AJM
 */
public class APIcon {
    ConfApiCon conf;
    
    public APIcon(){
        conf = new ConfApiCon();
    }
    
    public String getMethod(String path){
        StringBuilder response = new StringBuilder();
        try{

            URL url = new URL("http:://"+conf.getIp()+":"+conf.getPort()+conf.getRootPath()+path);
            System.out.println(url.toString());
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            
            int responseCode = conn.getResponseCode();
            if(responseCode != 200){
                throw new RuntimeException("Ocurrio un error: "+responseCode);
            }
            else{
                Scanner sc = new Scanner(url.openStream());
                while(sc.hasNext()){
                    response.append(sc.nextLine());
                }
                sc.close();
            }
                    
        }catch (Exception e){
            e.printStackTrace();
        }
        return response.toString();
    }
    
    
}
