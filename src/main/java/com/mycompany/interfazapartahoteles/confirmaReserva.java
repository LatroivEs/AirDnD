package com.mycompany.interfazapartahoteles;

import com.mycompany.conAPI.APIcon;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class confirmaReserva implements Initializable {

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
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

}
