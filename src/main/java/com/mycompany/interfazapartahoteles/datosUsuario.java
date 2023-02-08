package com.mycompany.interfazapartahoteles;

import com.mycompany.conAPI.APIcon;
import com.mycompany.models.dog.Client;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class datosUsuario implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    @FXML
    private TextField UserInput;
    @FXML
    private PasswordField PasswordInput;
    @FXML
    private Label feedback;

    @FXML
    private Button husuario;
    @FXML
    private Button hcontrasena;
    @FXML
    private Button hlogin;

    @FXML
    private void botonAtrasOnClick() throws IOException {
        App.setRoot("VistaReserva");
    }

    @FXML
    private void botonContinuarOnClick() throws IOException {
        App.setRoot("VistaReserva");
    }

}
