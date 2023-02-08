module com.mycompany.interfazapartahoteles {
    requires javafx.controls;
    requires javafx.fxml;
        
//needed for HTTP
    requires jasperreports;
    //needed for JSON
    requires com.google.gson;
    requires java.sql;
    requires javafx.web;
    //needed for JSON
    opens com.mycompany.models.dog to com.google.gson;
    

    opens com.mycompany.interfazapartahoteles to javafx.fxml;
    exports com.mycompany.interfazapartahoteles;
    exports com.mycompany.models.dog;
}

