module com.example.restcountryfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.example.restcountryfx to javafx.fxml;
    exports com.example.restcountryfx;
    exports com.example.restcountryfx.Models;
}