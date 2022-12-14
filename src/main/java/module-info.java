module com.mycompany.interfazapartahoteles {
    requires javafx.controls;
    requires javafx.fxml;
    
    //needed for HTTP
    requires unirest.java;
    
    //needed for JSON
    requires gson;
    requires java.sql;
    //needed for JSON
    opens com.mycompany.models.openVision to gson;
    opens com.mycompany.models.dog to gson;
    

    opens com.mycompany.interfazapartahoteles to javafx.fxml;
    exports com.mycompany.interfazapartahoteles;
}
