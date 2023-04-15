package Model;

public class Bet {

    private String event;
    private String selection;
    private String bookie;
    private double stake;
    private double odds;
    private enum BetOutcome {
        UNSETTLED,WIN,LOSS,VOID
    }
    private BetOutcome outcome;

    public Bet(String event, String selection, String bookie, double stake, double odds) {
        this.event = event;
        this.selection = selection;
        this.bookie = bookie;
        this.stake = stake;
        this.odds = odds;
        this.outcome = BetOutcome.UNSETTLED;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }

    public String getBookie() {
        return bookie;
    }

    public void setBookie(String bookie) {
        this.bookie = bookie;
    }

    public double getStake() {
        return stake;
    }

    public void setStake(double stake) {
        this.stake = stake;
    }

    public double getOdds() {
        return odds;
    }

    public void setOdds(double odds) {
        this.odds = odds;
    }

    public BetOutcome getOutcome() {
        return outcome;
    }
    public void setOutcome(BetOutcome outcome) {
        this.outcome = outcome;
    }
}
