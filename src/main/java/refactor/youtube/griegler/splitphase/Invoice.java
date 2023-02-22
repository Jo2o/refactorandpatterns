package refactor.youtube.griegler.splitphase;

import java.util.List;

public class Invoice {

    public String customer;
    public List<Performance> performances;

    public Invoice(String customer, List<Performance> performances) {
        this.customer = customer;
        this.performances = performances;
    }

    int calculateTotalAmount() {
        int totalAmount = 0;
        for (var performance : performances) {
            totalAmount += performance.calculateThisAmount();

        }
        return totalAmount;
    }

    int calculateVolumeCredits() {
        int volumeCredits = 0;
        for (var performance : performances) {
            volumeCredits += performance.calculateThisCredits();
        }
        return volumeCredits;
    }
}
