package com.mycompany.interfazapartahoteles;


import com.mycompany.models.dog.ReservaAirDnD;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class confirmaReserva implements Initializable {

    private APPData info;
    
    private Stage stagehelp;
    
    @FXML
    private Label entrada;
    @FXML
    private Label salida; 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        info = APPData.getAPPData();
        
        ReservaAirDnD airdd = APPData.getReservaAirDnD();
        
        entrada.setText(airdd.getStart_date().toString());
        salida.setText(airdd.getFinish_Date().toString());
    }


    @FXML
    private void finalizarOnClick() throws IOException {
        changeScene("VistaReserva");
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
            FXMLLoader fxmlLoader = new FXMLLoader(confirmaReserva.class.getResource("Help.fxml"));
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
                FXMLLoader fxmlLoader = new FXMLLoader(confirmaReserva.class.getResource("Help.fxml"));
                root= fxmlLoader.load();
                stagehelp.setScene(new Scene(root, 450, 450));
                stagehelp.show();
            }catch(IOException e) {
                e.printStackTrace();
        }
        }
      }
   

}
