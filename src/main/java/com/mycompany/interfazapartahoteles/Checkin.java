package com.mycompany.interfazapartahoteles;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mycompany.conAPI.APIcon;
import com.mycompany.conAPI.JasperDB;
import com.mycompany.models.dog.Check;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import java.sql.Date;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Checkin implements Initializable {

    @FXML
    private DatePicker date_checkin;
    
    private static final String DATE_FORMAT = "MM-dd-yyyy";
    
    private APPData info;
    
    private Stage stagehelp;
    
    @FXML 
    private AnchorPane root;
    
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
    
    @FXML
    private Button hfecha;
    @FXML
    private Button hinforme;
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        
        info = APPData.getAPPData();
        
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
        
        HelpInside.setTooltip(hfecha,
                "Pon la fecha en la cual quieres\n" +
                " ver las entradas de clientes.\n");
        HelpInside.setTooltip(hinforme,
                "Pulsa para generar el informe\n" +
                " de check-in.\n");
          
    }
            
            
    private void switchUI(String path) throws IOException {
        App.setRoot(path);
    }
    
    @FXML
    private void populateDataTable() throws Exception{
        
        LocalDate newLD = date_checkin.getValue();
        populateDataTable(newLD);
    }
    
    private void populateFirsTime() throws Exception{

        populateDataTable(LocalDate.now());
    }
    
    private void populateDataTable(LocalDate ld) throws Exception{
      Gson gson = new GsonBuilder().setDateFormat(DATE_FORMAT).create();        
      APIcon conn = new APIcon();
      date_checkin.setValue(ld);
      //System.out.println(ld.format(DateTimeFormatter.ofPattern("MM-dd-yyyy")));
      
      String json = conn.getMethod("checkin/"+ld.format(DateTimeFormatter.ofPattern(DATE_FORMAT)));
      
      //System.out.println( json);
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
    }
    
    @FXML
    private void checkinreport() throws Exception{
        JasperDB jdb = new JasperDB();
        JasperReport jr = null;
        String path = ".\\src\\main\\resources\\com\\mycompany\\informes\\CheckInReport.jasper";
        try{
            jr =(JasperReport)JRLoader.loadObjectFromFile(path);
        }catch(JRException e){
           System.out.println("Error al cargar la plantilla del informe");
        }
        
        Map param = new HashMap();
        param.put("Fecha", Date.valueOf(date_checkin.getValue()));
        
        JasperPrint jp = JasperFillManager.fillReport(jr,param,jdb.GetConnection());
        
        JasperViewer visualizador =  new JasperViewer(jp,false);
        visualizador.setTitle("Informe Check-In");
        visualizador.setVisible(true);
        
        jdb.close();
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