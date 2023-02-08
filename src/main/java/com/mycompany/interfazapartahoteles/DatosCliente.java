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

public class DatosCliente implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
        App.setRoot("VistaReserva");
    }

    @FXML
    private void botonSiguienteOnClick() throws IOException {
        App.setRoot("VistaReserva");
    }

}
