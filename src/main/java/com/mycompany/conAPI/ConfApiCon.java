/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.conAPI;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;

/**
 *
 * @author Antonio Moreno
 */
public class ConfApiCon {
    private String ip;
    private String port;
    private String rootPath;
    
    public ConfApiCon(){
        String file = "./confAPIRest.txt";
        Properties conf = new Properties();
		File f = new File(file);
		FileReader fr = null;
		try {
			
			if(f.exists()) {
				fr = new FileReader(f);
				conf.load(fr);
			}
			else {
				conf.setProperty("ip", "127.0.0.1");
				conf.setProperty("port", "4000");
				conf.setProperty("rootPath", "/api/");
				
				conf.store(new FileWriter(f),"Archivo Conf NuevoPassword");
			}
		}catch (Exception e) {
			System.out.println("Error en la carga de la configuracion inicial");
		}finally {
			try {
				fr.close();
			}catch (Exception e) {
				System.out.println("Error cerrando el archivo de configuracion.");
			}
		}
		
		//Bloque Carga Variables;
		ip = conf.getProperty("ip");
		port = conf.getProperty("port");
		rootPath = conf.getProperty("rootPath");
    }
    
    public String getPort(){
        return port;
    }
    
    public String getIp(){
        return ip;
    }
    
    public String getRootPath(){
        return rootPath;
    }
    
    
}
