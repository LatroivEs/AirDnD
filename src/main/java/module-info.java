module com.mycompany.interfazapartahoteles {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.interfazapartahoteles to javafx.fxml;
    exports com.mycompany.interfazapartahoteles;
}
