package Bill;

import java.time.LocalDateTime;
import java.util.Random;

import Warehouse.Article;
import log.LogFile;

/**
 * Bill class, creates a Bill
 *
 * @author Manuel Fellner
 * @version 2022-02-10
 */
public class Bill {
    private String billingID;
    private Article[] articles;
    private double price;

    /**
     * Constructor for a normal bill
     *
     * @param articles object-array
     */
    public Bill(Article[] articles) {
        this.billingID = this.generateBillingID();
        this.articles = new Article[articles.length];
        for (int i = 0; i < articles.length; i++) {
            if (articles[i] != null) {
                this.articles[i] = articles[i];
            }
        }
    }

    /**
     * Generating a random String, just a billing ID
     *
     * @return a random String, 15 letters in UppderCase format
     */
    public String generateBillingID() {
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 15;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString().toUpperCase();

        return generatedString;
    }


    /**
     * returns the billing ID
     *
     * @return this.billingID
     */
    public String getBillingID() {
        return this.billingID;
    }

    /**
     * calculates and returns the price in total
     *
     * @return calculated price, priceFromTheFirstArticle + priceFromTheSecondArticle + ...
     */
    public double getPrice() {
        double price = 0.0;
        for (int i = 0; i < this.articles.length; i++) {
            if (this.articles[i] != null) {
                price += this.articles[i].getPrice();
            }
        }
        return price;
    }

    /**
     * Trying to make a beautiful billing. Lmao
     *
     * @return the billing as a String
     */
    public String toString() {
        String bill = "";
        for (int i = 0; i < this.articles.length; i++) {
            bill += "-------------------RECHNUNG--------------------\n";
            bill += "ID-------------------NAME-----------------PREIS\n";
            if (this.articles[i] != null) {
                bill += this.articles[i].getUniqueIdentifier() + " - " + this.articles[i].getName() + " - " + this.articles[i].getPrice() + "€" + "\n";
            }
        }
        bill += "-----------------------------------------------\n";
        bill += "GESAMTSUMME: " + (int) this.getPrice() + " € " + "\n";
        bill += "BILLING-ID: " + this.billingID + "\n";
        bill += "-----------------------------------------------\n";
        bill += "VIELEN DANK FÜR IHREN EINKAUF!\n";
        bill += "-----------------------------------------------\n";
        return bill;
    }

    /**
     * Loggs the bill in a txt file in /log/
     *
     * @return true / false
     */
    public boolean logBill() {
        String content = "";
        if (this.billingID != "") {
            content += "--------------------AUFZEICHNUNG--------------------\n";
            content += "BILLING-ID: " + this.billingID + "\n";
            content += "TIME T DATE: " + LocalDateTime.now() + "\n";
            content += "-----------------------------------------------\n";
            content += this.toString();
        }
        return LogFile.writeFile(content, this.billingID);
    }
}
