package refactor.youtube.griegler.splitphase;

import java.text.NumberFormat;
import java.util.Locale;

/*
 1. moved format down where it's used
 2. extract thisAmount calculation to method
 3. rename perf to performance -> do not abbreviate
 4. move up thisAmount increment and inline
 5. extract method calculating totalAmount
 6. inline play
 7. split the loop
 8. extract totalAmount calculation
 9. extract thisCredits calculation
10. extract volumeCredits calculation
11. !!! move calculations into invoice obj !!!
12. !!! move calculations into performance obj !!!
13. inline
14. extract and rename to printPlainText
*/

public class TheatricalPlayersAfter {

    public String print(Invoice invoice) {
        InvoiceData invoiceData = new InvoiceData(
            invoice.customer,
            invoice.calculateTotalAmount(),
            invoice.calculateVolumeCredits());

        return printPlainText(invoiceData);
    }

    private String printPlainText(
        InvoiceData invoiceData) {
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        String result = String.format("Statement for %s%n", invoiceData.getCustomer());
        result += String.format("Amount owed is %s%n", format.format(invoiceData.getTotalAmount() / 100));
        result += String.format("You earned %s credits%n", invoiceData.getVolumeCredits());
        return result;
    }


    private static class InvoiceData {

        private final String customer;
        private final int totalAmount;
        private final int volumeCredits;

        private InvoiceData(String customer, int totalAmount, int volumeCredits) {
            this.customer = customer;
            this.totalAmount = totalAmount;
            this.volumeCredits = volumeCredits;
        }

        public String getCustomer() {
            return customer;
        }

        public int getTotalAmount() {
            return totalAmount;
        }

        public int getVolumeCredits() {
            return volumeCredits;
        }
    }
}
