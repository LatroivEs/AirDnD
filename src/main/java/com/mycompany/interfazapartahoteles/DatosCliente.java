package com.mycompany.interfazapartahoteles;

import com.mycompany.models.dog.Client;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DatosCliente implements Initializable {

    private APPData info;
    
    private Stage stagehelp;
    
    @FXML
    private TextField clienteNombreInput;
    @FXML
    private TextField apellidosClienteInput;
    @FXML
    private TextField documentoInput;
    @FXML
    private TextField clienteTelefonoInput;
    @FXML
    private TextField clienteEmailInput;
    @FXML
    private TextField clienteNacionalidadInput;
    @FXML
    private TextArea clienteObservacionesInput;
     
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        info = APPData.getAPPData();
        
        APPData.setClient(null);
        
        HelpInside.setTooltip(hnombre,
                "Introduce el nombre."
        );
        HelpInside.setTooltip(hapellidos,
                "Introduce los apellidos."
        );
        HelpInside.setTooltip(hdni,
                "Introduce el dni o pasaporte."
        );
        HelpInside.setTooltip(htelefono,
                "Introduce el telefono."
        );
        HelpInside.setTooltip(hemail,
                "Introduce el email."
        );
        HelpInside.setTooltip(hnacionalidad,
                "Introduce la nacionalidad."
        );
        HelpInside.setTooltip(hobservaciones,
                "Observaciones sobre la reserva."
        );
    }

    @FXML
    private Button hnombre;
    @FXML
    private Button hapellidos;
    @FXML
    private Button hdni;
    @FXML
    private Button htelefono;
    @FXML
    private Button hemail;
    @FXML
    private Button hnacionalidad;
    @FXML
    private Button hobservaciones;

    @FXML
    private void botonAtrasOnClick() throws IOException {
        changeScene("VistaReserva");
    }

    @FXML
    private void botonSiguienteOnClick() throws IOException {
        Client newCl = new Client();
        newCl.setName(clienteNombreInput.getText());
        newCl.setSurname(apellidosClienteInput.getText());
        newCl.setId_document(documentoInput.getText());
        newCl.setPhone(clienteTelefonoInput.getText());
        newCl.setEmail(clienteEmailInput.getText());
        newCl.setNationality(clienteNacionalidadInput.getText());
        newCl.setObservation(clienteObservacionesInput.getText());
        
        APPData.setClient(newCl);
        
        changeScene("datosUsuario");
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
            FXMLLoader fxmlLoader = new FXMLLoader(DatosCliente.class.getResource("Help.fxml"));
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
                FXMLLoader fxmlLoader = new FXMLLoader(DatosCliente.class.getResource("Help.fxml"));
                root= fxmlLoader.load();
                stagehelp.setScene(new Scene(root, 450, 450));
                stagehelp.show();
            }catch(IOException e) {
                e.printStackTrace();
        }
        }
      }
}
