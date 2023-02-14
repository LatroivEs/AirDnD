package com.mycompany.interfazapartahoteles;

import com.mycompany.conAPI.APIcon;
import com.mycompany.models.dog.Client;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Login implements Initializable{

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
    
    private Stage stagehelp;
    
    @FXML 
    private AnchorPane root;
    
    private APPData info;
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
     
    //Set evento captura F1
        javafx.event.EventHandler<javafx.scene.input.KeyEvent> handler = event -> {
            if (event.getCode() == javafx.scene.input.KeyCode.F1) {
                try {
                    helpOnclick();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        };
        if (root.getScene() != null) {
            root.getScene().addEventHandler(javafx.scene.input.KeyEvent.KEY_PRESSED, handler);
        }
        else {
            root.sceneProperty().addListener((obs, oldScene, newScene) -> {
                if (newScene != null) {
                    root.getScene().addEventHandler(javafx.scene.input.KeyEvent.KEY_PRESSED, handler);
                }
            });
        }        
        
        info = APPData.getAPPData();
        info.setInfo("Login");
        
        HelpInside.setTooltip(husuario,
               "Introduce tu nombre de usuario.");
        HelpInside.setTooltip(hcontrasena,
                "Introduce la contrasena asociada\n" +
                " a tu usuario.");
        HelpInside.setTooltip(hlogin,
                "Pulsa aqui para acceder" +
                " a la aplicacion");
     }
    
    
    
    @FXML
    private void cargarReserva() throws IOException {
        HashMap<String, String> listaUsuario = new HashMap<String, String>();
        Gson gson = new Gson();
        listaUsuario.put("Antonio", "1234");
        listaUsuario.put("Pedro", "12345");
        listaUsuario.put("", "");
        APIcon conn = new APIcon();
        String json = conn.getMethod("cliente/3");

        System.out.println(json.toLowerCase());
        Client cl1 = gson.fromJson(json.toLowerCase(), Client.class);
        System.err.println(cl1.getEmail());

        if (listaUsuario.containsKey(UserInput.getText())) {
            if (listaUsuario.get(UserInput.getText()).equals(PasswordInput.getText())) {
                App.setRoot("VistaReserva");
            } else {
                feedback.setText("Password Incorrecto");

            }
        } else {
            feedback.setText("Usuario Incorrecto");
        }
    }
    
    @FXML
     public void helpOnclick() {
        Parent root;
        if(stagehelp == null){
        try {
            
            FXMLLoader fxmlLoader = new FXMLLoader(APPData.getHelp());
            root= fxmlLoader.load();
            stagehelp = new Stage();
            stagehelp.setTitle("Ayuda");
            stagehelp.setScene(new Scene(root, 450, 450));
            stagehelp.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        }else{
            try{
            FXMLLoader fxmlLoader = new FXMLLoader(APPData.getHelp());
            root= fxmlLoader.load();
            stagehelp.setScene(new Scene(root, 450, 450));
            stagehelp.show();
            }catch(IOException e) {
                e.printStackTrace();
        }
        }
    }
    
}
