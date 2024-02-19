module com.example.restcountryfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.restcountryfx to javafx.fxml;
    exports com.example.restcountryfx;
}