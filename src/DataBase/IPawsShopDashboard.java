/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DataBase;

import java.util.ArrayList;

/**
 *
 * @author jayasundara
 */
public interface IPawsShopDashboard {
    
    public abstract boolean Add (PawsShopItemData pawsShopItemData);
    public abstract ArrayList <PawsShopItemData> View ();
    public abstract ArrayList <PawsShopItemData> Search (String Category);
    public abstract PawsShopItemData Delete(String ProductID);
    public abstract PawsShopItemData Update(String FindProductID, String UpdateProductID, String UpdateName, String UpdateCategory, String UpdatePrice, String UpdateQuantity);
    public abstract void Create (String UserID, String Password);
    public abstract boolean check (String CashierID, String Password);
    public abstract boolean check (String ProductID);
    
}
