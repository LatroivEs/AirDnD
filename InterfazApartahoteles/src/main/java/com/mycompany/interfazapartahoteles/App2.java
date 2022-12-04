package com.mycompany.interfazapartahoteles;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App2 extends Application {

    private Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("VistaReserva"), 1200, 800);
        stage.setScene(scene);
        stage.show();
    }

    void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App2.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public App2() {
        launch();
    }

}