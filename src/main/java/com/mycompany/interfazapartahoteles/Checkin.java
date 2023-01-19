package com.mycompany.interfazapartahoteles;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mycompany.conAPI.APIcon;
import com.mycompany.models.dog.Check;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Checkin implements Initializable {

    @FXML
    private DatePicker date_checkin;
    
    private static final String DATE_FORMAT = "MM-dd-yyyy";
    
    //TableView
    @FXML
    private TableView<Check> tableView;
    @FXML
    private TableColumn<Check, String> n_apar;
    @FXML
    private TableColumn<Check, String> name;
    @FXML
    private TableColumn<Check, String> surname;
    @FXML
    private TableColumn<Check, String> phone;
    @FXML
    private TableColumn<Check, String> email;
    @FXML
    private TableColumn<Check, String> details;
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        n_apar.setCellValueFactory(new PropertyValueFactory<Check, String>("apart_name_id"));
        name.setCellValueFactory(new PropertyValueFactory<Check, String>("name"));
        surname.setCellValueFactory(new PropertyValueFactory<Check, String>("surname"));
        phone.setCellValueFactory(new PropertyValueFactory<Check, String>("phone"));
        email.setCellValueFactory(new PropertyValueFactory<Check, String>("email"));
        details.setCellValueFactory(new PropertyValueFactory<Check, String>("details"));
        try{
            populateFirsTime();
        }catch(Exception e){
            System.err.println("Error iniciando el datatable");
        }
          
    }
            
            
    private void switchUI(String path) throws IOException {
        App.setRoot(path);
    }
    @FXML
    private void populateDataTable() throws Exception{
        
        Gson gson = new GsonBuilder().setDateFormat(DATE_FORMAT).create();        
        APIcon conn = new APIcon();
        System.out.println(date_checkin.getValue().format(DateTimeFormatter.ofPattern("MM-dd-yyyy")));
        String json = conn.getMethod("checkin/"+date_checkin.getValue().format(DateTimeFormatter.ofPattern("MM-dd-yyyy")));
        System.out.println( json);
        Check[] checkList = gson.fromJson(json.toLowerCase(), Check[].class);
        if(checkList.length>0){
            System.out.println(checkList[0].getApart_name_id()+" "+checkList[0].getName()+" "+checkList[0].getSurname());
        }
        ObservableList<Check> obCheckList = FXCollections.observableArrayList();
        obCheckList.addAll(Arrays.asList(checkList));
         if(checkList.length>0) {
            tableView.setItems(obCheckList);
        }else{
            tableView.setItems(null);
        }
        System.out.println(obCheckList);
    }
    
      private void populateFirsTime() throws Exception{
        
        Gson gson = new GsonBuilder().setDateFormat(DATE_FORMAT).create();        
        APIcon conn = new APIcon();
        LocalDate ld = LocalDate.of(2022,12,05);
        date_checkin.setValue(LocalDate.of(2022,12,05));
        System.out.println(ld.format(DateTimeFormatter.ofPattern("MM-dd-yyyy")));
        String json = conn.getMethod("checkin/"+ld.format(DateTimeFormatter.ofPattern("MM-dd-yyyy")));
        System.out.println( json);
        Check[] checkList = gson.fromJson(json.toLowerCase(), Check[].class);
        if(checkList.length>0){
            System.out.println(checkList[0].getApart_name_id()+" "+checkList[0].getName()+" "+checkList[0].getSurname());
        }
        ObservableList<Check> obCheckList = FXCollections.observableArrayList();
        obCheckList.addAll(Arrays.asList(checkList));
        if(checkList.length>0) {
            tableView.setItems(obCheckList);
        }else{
            tableView.setItems(null);
        }
        System.out.println(obCheckList);
    }
}