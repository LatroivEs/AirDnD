package com.mycompany.interfazapartahoteles;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;



public class Help implements Initializable {

    @FXML
    private WebView webViewer;
    
    @FXML
    private Label title;
   
    private APPData info;
    
    private WebEngine engine;
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        info = APPData.getAPPData();
         
        engine = webViewer.getEngine();
         
        try{
            String content = HelpInside.readStringFromURL(App.loadHelp(info.getInfo()).toString());
            
            engine.loadContent(content);
            }
        catch(Exception e){
            System.out.println("Error cargando html");
        }
    }
            
    
}