/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase;

/**
 *
 * @author jayasundara
 */
public class PawsShopItemData {

    private  String ProductID;
    private  String Name;
    private  String Category;
    private  String Price;
    private  String Quantity;

    public PawsShopItemData(String ProductID, String Name, String Category, String Price, String Quantity) {
        this.ProductID = ProductID;
        this.Name = Name;
        this.Category = Category;
        this.Price = Price;
        this.Quantity = Quantity;
    }
    
    public String getProductID() {
        return ProductID;
    }

    public String getName() {
        return Name;
    }

    public String getCategory() {
        return Category;
    }

    public String getPrice() {
        return Price;
    }

    public String getQuantity() {
        return Quantity;
    }

}
