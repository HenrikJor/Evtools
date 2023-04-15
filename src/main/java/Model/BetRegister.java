package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class BetRegister {
    private ObservableList<Bet> bets;

    public BetRegister() {
        bets = FXCollections.observableArrayList();
    }

    public void addBet(Bet bet) {
        bets.add(bet);
    }

    public void removeBet(Bet bet) {
        bets.remove(bet);
    }
}
