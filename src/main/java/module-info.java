module com.example.evtools2 {
    requires javafx.controls;
    requires javafx.fxml;
    opens com.example.evtools2 to javafx.fxml;
    opens Model to javafx.base;
    exports com.example.evtools2;
}
