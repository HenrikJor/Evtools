package com.example.evtools2;


import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainMenuController {
    public MainMenuController() {
    }

    @FXML
    public void openHedgeCalculator(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/com/example/evtools2/hedgeCalc.fxml"));
            Parent root = (Parent)fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException var5) {
            var5.printStackTrace();
        }

    }
}
