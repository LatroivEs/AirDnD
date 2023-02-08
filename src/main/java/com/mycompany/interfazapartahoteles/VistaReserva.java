package com.mycompany.interfazapartahoteles;

import com.mycompany.conAPI.APIcon;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class VistaReserva implements Initializable {

    @FXML
    private Button htipoApartamento;
    @FXML
    private Button hentradaVReserva;
    @FXML
    private Button hsalidaVReserva;
    @FXML
    private Button hNumApartamento;
    @FXML
    private Button hReservar;
    @FXML
    private Button hprecio;
    
    private APPData info;
    
    private Stage stagehelp;
    
    @FXML 
    private AnchorPane root;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
                 
        info = APPData.getAPPData();
        
        HelpInside.setTooltip(htipoApartamento,
                "Introduce el tipo de apartamento.");
        HelpInside.setTooltip(hentradaVReserva,
                "Introduce la fecha de entrada.");
        HelpInside.setTooltip(hsalidaVReserva,
                "Introduce la fecha de salida.");
        HelpInside.setTooltip(hNumApartamento,
                "Introduce el numero de apartamento.");
        HelpInside.setTooltip(hReservar,
                "Pulsa aqui para reservar");
        HelpInside.setTooltip(hprecio,
                "Precio de la reserva");
    }

    private void switchUI(String path) throws IOException {
        App.setRoot(path);
    }

    @FXML
    private void onReserva() throws IOException {
        switchUI("Checkin");
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
            System.out.println(App.loadFXML("help"));
            root= App.loadFXML("help");
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
                root= App.loadFXML("help");
                stagehelp.setScene(new Scene(root, 450, 450));
                stagehelp.show();
            }catch(IOException e) {
                e.printStackTrace();
        }
        }
      }
    
}
