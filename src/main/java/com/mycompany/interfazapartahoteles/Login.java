package com.mycompany.interfazapartahoteles;
import com.mycompany.conAPI.APIcon;
import com.mycompany.models.dog.Client;
import com.google.gson.Gson;
import java.io.IOException;
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
        Gson gson = new Gson();
        listaUsuario.put("Antonio","1234");
        listaUsuario.put("Pedro","12345");
        listaUsuario.put("","");
        APIcon conn = new APIcon();
        String json = conn.getMethod("cliente/3");
        
         System.out.println(json.toLowerCase());
         Client cl1 = gson.fromJson(json.toLowerCase(), Client.class);
         System.err.println(cl1.getEmail());
        
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
