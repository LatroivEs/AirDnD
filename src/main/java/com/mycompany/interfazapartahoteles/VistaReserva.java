package com.mycompany.interfazapartahoteles;

import com.mycompany.conAPI.APIcon;
import java.io.IOException;
import javafx.fxml.FXML;

public class VistaReserva {
     
    private void switchUI(String path) throws IOException {
        App.setRoot(path);
    }
    @FXML
    private void onReserva() throws IOException {
        switchUI("Checkin");
    }
 
}