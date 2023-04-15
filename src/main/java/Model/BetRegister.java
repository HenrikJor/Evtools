package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class BetRegister {
    public ObservableList<Bet> getBets() {
        return bets;
    }

    public void setBets(ObservableList<Bet> bets) {
        this.bets = bets;
    }

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
