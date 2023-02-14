package com.mycompany.interfazapartahoteles;


import com.mycompany.models.dog.Client;
import com.mycompany.models.dog.ReservaAirDnD;
import com.mycompany.session.AirDnDSession;
import java.io.IOException;
import java.net.URL;
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
import javafx.stage.Stage;

public class datosUsuario implements Initializable {

    
    @FXML
    private Label nombre;
    @FXML
    private Label apellidos;
    @FXML
    private Label email;
    @FXML
    private Label dni;
    @FXML
    private Label telefono;
    @FXML
    private Label entrada;
    @FXML
    private Label salida;  
    @FXML
    private Label nombretarjeta;
    
    private APPData info;
    
    private Stage stagehelp;

    @FXML
    private void botonAtrasOnClick() throws IOException {
        changeScene("DatosCliente");
    }

    @FXML
    private void botonContinuarOnClick() throws IOException {
        changeScene("confirmaReserva");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        info = APPData.getAPPData();
        
        Client cl = APPData.getClient();
        nombre.setText(cl.getName());
        apellidos.setText(cl.getSurname());
        email.setText(cl.getEmail());
        dni.setText(cl.getId_document());
        telefono.setText(cl.getPhone());
        
        ReservaAirDnD airdd = APPData.getReservaAirDnD();
        
        entrada.setText(airdd.getStart_date().toString());
        salida.setText(airdd.getFinish_Date().toString());
        nombretarjeta.setText(cl.getName()+" "+cl.getSurname());     
        
    }
    
        //Nav Event
    @FXML
    private void chechinOnClick(){
        changeScene("Checkin");
    }
    @FXML
    private void chechoutOnClick(){
        changeScene("Checkout");
    }
    @FXML
    private void reservaOnClick(){
        changeScene("VistaReserva");
    }
    
    private void changeScene(String scene){
        try{
            App.setRoot(scene);
        }catch(IOException ie){
            ie.printStackTrace();
        }
    }
    
    //HelpView    
    @FXML
      public void helpOnclick() {
        Parent root;
        if(stagehelp == null){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(datosUsuario.class.getResource("Help.fxml"));
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
                FXMLLoader fxmlLoader = new FXMLLoader(datosUsuario.class.getResource("Help.fxml"));
                root= fxmlLoader.load();
                stagehelp.setScene(new Scene(root, 450, 450));
                stagehelp.show();
            }catch(IOException e) {
                e.printStackTrace();
        }
        }
      }
    
}
