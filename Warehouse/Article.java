package Warehouse;
import java.util.Random;

/**
 * Article - A simple Article class, that represents an article like for example Milk
 *
 * @author Manuel Fellner
 * @version 2022-02-10
 */
public class Article {
    private final int uniqueIdentifier = this.generateArticleID();
    private String name;
    private double price;

    /**
     * Constructor for an Article
     *
     * @param name             the name of the Article, e.g. "Milk", "Cheeseburger", ...
     * @param price            the price of the Article, e.g. 1.20 €
     */
    public Article(String name, double price) {
        if (name != "" && price != 0) {
            this.name = name;
            this.price = price;
        }
    }

    public int generateArticleID()  {
        Random rdm = new Random();
        return rdm.nextInt(999999999);
    }

    /**
     * returns the unique identifier of the Article
     *
     * @return this.uniqueIdentifier
     */
    public int getUniqueIdentifier() {
        return this.uniqueIdentifier;
    }

    /**
     * returns the name of the Article
     *
     * @return this.name
     */
    public String getName() {
        return this.name;
    }

    /**
     * returns the price of the Article
     *
     * @return this.price
     */
    public double getPrice() {
        return this.price;
    }
}
