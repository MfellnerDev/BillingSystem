package Warehouse;

/**
 * A Warehouse - Basicially an Array of article Objects
 *
 * @author Manuel Fellner
 * @version 2022-02-10
 */
public class Warehouse {
    private Article[] productList;

    /**
     * Constructor for a Warehouse
     *
     * @param productList an Array of Article Objects that builds a Warehouse
     */
    public Warehouse(Article[] productList) {
        this.productList = new Article[productList.length];
        for (int i = 0; i < productList.length; i++) {
            if (productList[i] != null) {
                this.productList[i] = productList[i];
            }
        }
    }

    /**
     * Searchs the unique ID of an Object in the object array, just like you're searching smth on Amazon. Lmao.
     *
     * @param uniqueIdentifier the unique ID of the product
     * @return array-index of the product, if the product was not found -> -1
     */
    public int searchArticle(int uniqueIdentifier) {
        for (int i = 0; i < this.productList.length; i++) {
            if (this.productList[i] != null) {
                if (this.productList[i].getUniqueIdentifier() == uniqueIdentifier) {
                    return i;
                }
            }
        }
        return -1;
    }
}
