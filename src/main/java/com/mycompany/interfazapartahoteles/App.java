package com.mycompany.interfazapartahoteles;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    
    private static APPData info;
    

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("Login"), 1200, 800);
        stage.setScene(scene);
        stage.show();
        info = APPData.getAPPData();
        info.setInfo("Login");
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
        info.setInfo(fxml);        
    }

    static Parent loadFXML(String fxml) throws IOException {
        System.out.println(App.class.getResource(fxml + ".fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    static URL loadHelp(String html) throws IOException{
        String path = html + ".html";
        System.out.println(App.class.getResource(path));
        System.out.println(path);
        
        return App.class.getResource(path);
    }

    public static void main(String[] args) {
        launch();
    }

}