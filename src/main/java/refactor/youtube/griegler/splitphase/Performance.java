package refactor.youtube.griegler.splitphase;

public class Performance {

    public Play play;
    public int audience;

    public Performance(Play play, int audience) {
        this.play = play;
        this.audience = audience;
    }

    int calculateThisAmount() {
        var thisAmount = 40000;
        if (audience > 30) {
            thisAmount += 1000 * (audience - 30);
        }
        return thisAmount;
    }

    int calculateThisCredits() {
        var thisCredits = Math.max(audience - 30, 0);
        if ("comedy".equals(play.type)) {
            thisCredits += Math.floor((double) audience / 5);
        }
        return thisCredits;
    }
}
