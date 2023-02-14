package com.mycompany.interfazapartahoteles;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mycompany.conAPI.APIcon;
import com.mycompany.conAPI.JasperDB;
import com.mycompany.models.dog.Check;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Checkout implements Initializable{

    @FXML
    private DatePicker date_checkout;
    @FXML
    private Button hfechaOut;
    @FXML
    private Button hinformeOut;
    
    private static final String DATE_FORMAT = "MM-dd-yyyy";
    
    private APPData info;
    
    private Stage stagehelp;
    
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
    private AnchorPane root;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
                 
        info = APPData.getAPPData();
        
        HelpInside.setTooltip(hfechaOut,
                "Introduce la fecha en la que\n."
                + " deseas ver las salidas de clientes.");
        HelpInside.setTooltip(hinformeOut,
                "Pulsa para generar el informe\n"
                + " de check-out.");
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
        
        LocalDate newLD = date_checkout.getValue();
        populateDataTable(newLD);
    }
    
    private void populateFirsTime() throws Exception{

        populateDataTable(LocalDate.now());
    }
    
    private void populateDataTable(LocalDate ld) throws Exception{
      Gson gson = new GsonBuilder().setDateFormat(DATE_FORMAT).create();        
      APIcon conn = new APIcon();
      date_checkout.setValue(ld);
      //System.out.println(ld.format(DateTimeFormatter.ofPattern("MM-dd-yyyy")));
      
      String json = conn.getMethod("checkout/"+ld.format(DateTimeFormatter.ofPattern(DATE_FORMAT)));
      
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
    private void checkoutreport() throws Exception{
        JasperDB jdb = new JasperDB();
        JasperReport jr = null;
        try{
            jr =(JasperReport)JRLoader.loadObject(Checkin.class.getResource("CheckOutReport.jasper"));
        }catch(JRException e){
           System.out.println("Error al cargar la plantilla del informe");
        }
        
        Map param = new HashMap();
        param.put("Fecha", Date.valueOf(date_checkout.getValue()));
        
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
            FXMLLoader fxmlLoader = new FXMLLoader(Checkout.class.getResource("Help.fxml"));
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
                FXMLLoader fxmlLoader = new FXMLLoader(Checkout.class.getResource("Help.fxml"));
                root= fxmlLoader.load();
                stagehelp.setScene(new Scene(root, 450, 450));
                stagehelp.show();
            }catch(IOException e) {
                e.printStackTrace();
        }
        }
      }
}
