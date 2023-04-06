package com.example.evtools2;


import Model.HedgeCalc;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

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

    public HedgeCalcController() {
    }

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
        } catch(NumberFormatException e){

        }
    }

        public void initialize() {
            ChangeListener<String> inputChangeListener = (observable, oldValue, newValue) -> updateOutputFields();

            oddsTextField.textProperty().addListener(inputChangeListener);
            stakeTextField.textProperty().addListener(inputChangeListener);
            hedgeOddsTextField.textProperty().addListener(inputChangeListener);
        }
}
