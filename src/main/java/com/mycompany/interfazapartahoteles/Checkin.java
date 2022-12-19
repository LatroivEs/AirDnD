package com.mycompany.interfazapartahoteles;

import com.google.gson.Gson;
import com.mycompany.conAPI.APIcon;
import com.mycompany.models.dog.Check;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Checkin {

    @FXML
    private DatePicker date_checkin;
    @FXML
    private TableView tableView;
       
    
    private void switchUI(String path) throws IOException {
        App.setRoot(path);
    }
    @FXML
    private void populateDataTable() throws Exception{
        
        TableColumn n_apar = new TableColumn("NºAPAR"); 
        TableColumn name = new TableColumn("Nombre"); 
        TableColumn surname = new TableColumn("Apellidos"); 
        TableColumn phone = new TableColumn("Telefono"); 
        TableColumn date = new TableColumn("Fecha"); 
        TableColumn details = new TableColumn("Detalles");
        tableView.getColumns().addAll(n_apar,name, surname,phone, date,details);
        
        
        Gson gson = new Gson();        
        APIcon conn = new APIcon();
        System.out.println(date_checkin.getValue().format(DateTimeFormatter.ofPattern("MM-dd-yyyy")));
        String json = conn.getMethod("checkin/"+date_checkin.getValue().format(DateTimeFormatter.ofPattern("MM-dd-yyyy")));
        System.out.println( json);
        Check[] checkList = gson.fromJson(json.toLowerCase(), Check[].class);
        ObservableList<Check> obCheckList = FXCollections.observableArrayList(checkList);
        
        /*
        n_apar.setCellValueFactory(new PropertyValueFactory<Check, int>("NºAPAR"); 
        TableColumn name = new TableColumn("Nombre"); 
        TableColumn surname = new TableColumn("Apellidos"); 
        TableColumn phone = new TableColumn("Telefono"); 
        TableColumn date = new TableColumn("Fecha"); 
        TableColumn details = new TableColumn("Detalles");*/
    }
}