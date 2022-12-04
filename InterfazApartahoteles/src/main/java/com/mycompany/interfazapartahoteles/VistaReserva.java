package com.mycompany.interfazapartahoteles;

import java.io.IOException;
import javafx.fxml.FXML;

public class VistaReserva {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}