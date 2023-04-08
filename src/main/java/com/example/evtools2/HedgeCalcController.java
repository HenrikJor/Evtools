package com.example.evtools2;


import Model.HedgeCalc;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class HedgeCalcController {
    private HedgeCalc hedge = new HedgeCalc();
    @FXML
    private TextField oddsTextField;
    @FXML
    private TextField stakeTextField;
    @FXML
    private TextField hedgeAmountTextField;
    @FXML
    private TextField totalProfitTextField;
    @FXML
    private TextField hedgeOddsTextField;


    private void updateOutputFields() {
        try {
            double odds = 0.0;
            double stake = 0.0;
            double hedgeodds = 0.0;
            odds = Double.parseDouble(this.oddsTextField.getText());
            stake = Double.parseDouble(this.stakeTextField.getText());
            hedgeodds = Double.parseDouble(this.hedgeOddsTextField.getText());
            HedgeCalc var10000 = this.hedge;
            double hedgeAmount = HedgeCalc.hedgeBet(stake, odds, hedgeodds).getHedgeBetAmount();
            var10000 = this.hedge;
            double totalProfit = HedgeCalc.hedgeBet(stake, odds, hedgeodds).getTotalProfit();
            this.hedgeAmountTextField.setText(String.format("%.2f", hedgeAmount));
            this.totalProfitTextField.setText(String.format("%.2f", totalProfit));
        } catch (NumberFormatException e) {

        }
    }

    public void initialize() {
        ChangeListener<String> inputChangeListener = (observable, oldValue, newValue) -> updateOutputFields();

        oddsTextField.textProperty().addListener(inputChangeListener);
        stakeTextField.textProperty().addListener(inputChangeListener);
        hedgeOddsTextField.textProperty().addListener(inputChangeListener);
    }

    public void openMainMenu(ActionEvent event) {
        try {
            // Load the main menu FXML file
            Parent mainMenuRoot = FXMLLoader.load(getClass().getResource("main_menu.fxml"));

            // Get the current scene and window (stage)
            Scene currentScene = ((Node) event.getSource()).getScene();
            Stage currentStage = (Stage) currentScene.getWindow();

            // Set the main menu root as the scene's root
            currentScene.setRoot(mainMenuRoot);

            // Set the new scene on the stage
            currentStage.setScene(currentScene);
            currentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
