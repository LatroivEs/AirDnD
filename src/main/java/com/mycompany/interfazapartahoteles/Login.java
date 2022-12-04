package com.mycompany.interfazapartahoteles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Login {

    @FXML
    private TextField UserInput;
    @FXML
    private PasswordField PasswordInput;
    @FXML
    private Label feedback;
    
     @FXML
    private void cargarReserva() throws IOException {
        HashMap<String, String> listaUsuario = new HashMap<String, String>();
        
        listaUsuario.put("Antonio","1234");
        listaUsuario.put("Pedro","12345");
        
        if(listaUsuario.containsKey(UserInput.getText()))
            if(listaUsuario.get(UserInput.getText()).equals(PasswordInput.getText())){
                App.setRoot("VistaReserva");
            }else{
                feedback.setText("Password Incorrecto");             
            }
        else{
            feedback.setText("Usuario Incorrecto");
        }
            
    }
}
