import Bill.Bill;
import Warehouse.Article;
import Warehouse.Warehouse;

/**
 *  The Main Class for the BillingSystem project. Just a test class right now, a GUI's coming soon!
 *
 * @author Manuel Fellner
 * @version 2022-02-10
 */

public class MainApplication {
    public static void main(String[] args)  {
        Article a1 = new Article("Milk - 1L", 1.50);
        Article a2 = new Article("Carrot - 1KG", 2.50);
        Article a3 = new Article("Monster Energy 500ML", 1.99);
        Article a4 = new Article("Cheeseburger", 1);
        Article a5 = new Article("Alcohol - 1L", 20.99);
        Article a6 = new Article("Cucumber - 1 Piece", 0.99);
        Article a7 = new Article("Banana - 5 Piece", 2.60);
        Article a8 = new Article("Eggs - 20 Piece", 1.69);
        Article a9 = new Article("Pringles Chips Sour Cream", 3.40);
        Article a10 = new Article("Coca Cola - 1L", 2.30);
        Article[] articleArray = {a1, a2, a3, a4, a5, a6, a7, a8, a9, a10};
        Warehouse wrHs = new Warehouse(articleArray);

        Bill bill1 = new Bill(articleArray);
        System.out.println("TEST STARTING");
        System.out.println("Billing ID: " + bill1.getBillingID() + " | Price: " + bill1.getPrice());
        System.out.println("-----------------------------------------------");
        System.out.println(bill1.toString());
        System.out.println(bill1.logBill());
    }
}
