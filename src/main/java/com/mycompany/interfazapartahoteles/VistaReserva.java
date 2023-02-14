package com.mycompany.interfazapartahoteles;

import com.mycompany.conAPI.APIcon;
import com.mycompany.models.dog.ReservaAirDnD;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.sql.Date;

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
    @FXML
    private DatePicker entradaSelector;
    @FXML
    private DatePicker salidaSelector;
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
        
        try{
        ReservaAirDnD rairdnd = new ReservaAirDnD();
        
        rairdnd.setStart_date(Date.valueOf(entradaSelector.getValue()));
        rairdnd.setFinish_Date(Date.valueOf(salidaSelector.getValue()));
        
        APPData.setReservaAirDnD(rairdnd);
        
        switchUI("DatosCliente");
        }catch(Exception e){
            System.err.println("Campos Obligatorios no rellenos");   
        }
        
        
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
            FXMLLoader fxmlLoader = new FXMLLoader(VistaReserva.class.getResource("Help.fxml"));
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
                FXMLLoader fxmlLoader = new FXMLLoader(VistaReserva.class.getResource("Help.fxml"));
                root= fxmlLoader.load();
                stagehelp.setScene(new Scene(root, 450, 450));
                stagehelp.show();
            }catch(IOException e) {
                e.printStackTrace();
        }
        }
      }
    
}
