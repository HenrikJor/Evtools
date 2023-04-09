package Model;

public class BetCalc {
    public static HedgeBetResult hedgeBet(double originalBetAmount, double originalOdds, double hedgeOdds) {
        // Calculate the potential win amount of the original bet
        double originalWinAmount = originalBetAmount * originalOdds;

        // Calculate the required hedge bet amount based on the original win amount and hedge odds
        double hedgeBetAmount = originalWinAmount / hedgeOdds;

        // Calculate the profit if the original bet wins
        double originalBetProfit = originalWinAmount - originalBetAmount - hedgeBetAmount;

        // Calculate the profit if the hedge bet wins
        double hedgeBetProfit = hedgeBetAmount * hedgeOdds - originalBetAmount;

        // The total profit should be the same (or very close) for both outcomes
        double totalProfit = Math.min(originalBetProfit, hedgeBetProfit);

        // Return the result as a Model.HedgeBetResult object
        return new HedgeBetResult(originalBetAmount + hedgeBetAmount, totalProfit, hedgeBetAmount);
    }


    /**
     * Calculates the bookmaker's margin for a series of bets with given decimal odds.
     *
     * @param decimalOdds The decimal odds for every possible outcome of an event
     * @return The bookmaker's payout percentage as a double
     */
    public static double calculatePayoutPercentage(double... decimalOdds) {
        double totalImpliedProbability = 0.0;

        for (double odd : decimalOdds) {
            totalImpliedProbability += (1 / odd) * 100;
        }

        double payoutPercentage = 100 / totalImpliedProbability * 100;
        return payoutPercentage;
    }


    /**
     * @param correctOdds The predicted or known correct odds representing the true probability of an event
     * @return The predicted or known value of a bet expressed as a percentage
     */
    public static double calculateCLV(double placedOdds, double correctOdds) {
        // Calculates the percentage value of a bet based on the placed and correct odds
        double clv = ((((placedOdds / correctOdds) - 1)) *100);
        return clv;
    }


// methods for converting odds types :

    public double usToDecimal(int usOdds) {
        return usOdds > 0 ? (usOdds / 100.0) + 1 : 1 + (100.0 / Math.abs(usOdds));
    }

    public static String usToFractional(int usOdds) {
        int numerator = usOdds > 0 ? usOdds : 100;
        int denominator = usOdds > 0 ? 100 : Math.abs(usOdds);
        return String.format("%d/%d", numerator, denominator);
    }

    public int decimalToUs(double decimalOdds) {
        return decimalOdds >= 2 ? (int) ((decimalOdds - 1) * 100) : (int) (100 / (decimalOdds - 1));
    }

    public String decimalToFractional(double decimalOdds) {
        int numerator = (int) Math.round((decimalOdds - 1) * 100);
        int denominator = 100;
        return String.format("%d/%d", numerator, denominator);
    }

    public int fractionalToUs(String fractionalOdds) {
        String[] parts = fractionalOdds.split("/");
        int numerator = Integer.parseInt(parts[0]);
        int denominator = Integer.parseInt(parts[1]);
        int sign = denominator > 0 ? 1 : -1;
        return sign * (Math.abs(numerator) >= Math.abs(denominator) ? Math.abs(numerator) / Math.abs(denominator) * 100 + Math.abs(numerator) % Math.abs(denominator) * sign : numerator != 0 ? (int) (-100 * sign / (numerator / (double) denominator)) : 0);
    }

    public static double fractionalToDecimal(String fractionalOdds) {
        String[] parts = fractionalOdds.split("/");
        return 1 + (Double.parseDouble(parts[0]) / Double.parseDouble(parts[1]));
    }
}