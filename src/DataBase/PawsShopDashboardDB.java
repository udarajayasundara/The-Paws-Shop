/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jayasundara
 */
public class PawsShopDashboardDB implements IPawsShopDashboard {

    @Override
    public boolean Add(PawsShopItemData pawsShopItemData) {
        try {
            FileWriter fileWriter = new FileWriter("E:\\PawsShopItems.txt", true);
            fileWriter.write(pawsShopItemData.getProductID() + " " + pawsShopItemData.getName() + " " + pawsShopItemData.getCategory() + " " + pawsShopItemData.getPrice() + " " + pawsShopItemData.getQuantity() + "\n");
            fileWriter.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(PawsShopDashboardDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<PawsShopItemData> View() {
        File file = new File("E:\\PawsShopItems.txt");

        try {
            ArrayList<PawsShopItemData> arrayList = new ArrayList<>();
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] credentials = line.split(" ");

                String ProductID = credentials[0];
                String Name = credentials[1];
                String Category = credentials[2];
                String Price = credentials[3];
                String Quantity = credentials[4];

                PawsShopItemData pawsShopItemData = new PawsShopItemData(ProductID, Name, Category, Price, Quantity);
                arrayList.add(pawsShopItemData);
            }
            scanner.close();
            return arrayList;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PawsShopDashboardDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<PawsShopItemData> Search(String Category) {
        ArrayList<PawsShopItemData> arrayList = View();
        ArrayList<PawsShopItemData> SearchCategoryView = new ArrayList<>();

        if (arrayList != null) {
            for (PawsShopItemData pawsShopItemData : arrayList) {
                if (pawsShopItemData.getCategory().equals(Category)) {
                    SearchCategoryView.add(pawsShopItemData);  // Add directly without re-creating the object
                }
            }
        }
        return SearchCategoryView;
    }

    @Override
    public PawsShopItemData Delete(String ProductID) {
        File file = new File("E:\\PawsShopItems.txt");
        File tempFile = new File("E:\\TempPawsShopItems.txt");
        PawsShopItemData deletedItemData = null; // Initialize to null

        try {
            ArrayList<String> lines = new ArrayList<>();
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] credentials = line.split(" ");

                // Assuming the structure: ProductID Name Category Price Quantity
                if (credentials[0].equals(ProductID)) {
                    // Create PawsShopItemData for the deleted item
                    deletedItemData = new PawsShopItemData(credentials[0], credentials[1], credentials[2], credentials[3], credentials[4]);
                } else {
                    lines.add(line); // Keep other lines
                }
            }
            scanner.close();

            // Write remaining lines back to the temp file
            try (FileWriter fileWriter = new FileWriter(tempFile, true)) {
                for (String line : lines) {
                    fileWriter.write(line + "\n");
                }
            }

            // Delete the original file and rename the temp file
            if (file.delete()) {
                tempFile.renameTo(file);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PawsShopDashboardDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PawsShopDashboardDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return deletedItemData; // Return the deleted item's data, or null if not found
    }

    @Override
    public PawsShopItemData Update(String FindProductID, String UpdateProductID, String UpdateName, String UpdateCategory, String UpdatePrice, String UpdateQuantity) {
        File file = new File("E:\\PawsShopItems.txt");
        File tempFile = new File("E:\\TempPawsShopItems.txt");
        PawsShopItemData updatedItemData = null;
        ArrayList<String> lines = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] credentials = line.split(" ");

                // Validate the array length
                if (credentials.length < 5) {
                    continue; // Skip if not enough data
                }

                // If the product ID matches, update the item
                if (credentials[0].equals(FindProductID)) {
                    updatedItemData = new PawsShopItemData(UpdateProductID, UpdateName, UpdateCategory, UpdatePrice, UpdateQuantity);
                    lines.add(UpdateProductID + " " + UpdateName + " " + UpdateCategory + " " + UpdatePrice + " " + UpdateQuantity);
                } else {
                    lines.add(line); // Keep the existing line
                }
            }
        } catch (FileNotFoundException ex) {
            // Handle exception
        }

        // Write back to temporary file
        try (FileWriter fileWriter = new FileWriter(tempFile)) {
            for (String line : lines) {
                fileWriter.write(line + "\n");
            }
        } catch (IOException ex) {
            // Handle exception
        }

        // Delete the original file and rename the temporary file
        if (file.delete()) {
            tempFile.renameTo(file);
        } else {
            // Handle deletion failure
        }

        return updatedItemData; // Return updated item data
    }

    @Override
    public void Create(String UserID, String Password) {

        try {
            FileWriter filewriter = new FileWriter("E:\\CashierNewLogins.txt", true);
            filewriter.write(UserID + " " + Password + "\n");
            filewriter.close();

        } catch (IOException ex) {
            Logger.getLogger(PawsShopDashboardDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean check(String CashierID, String Password) {
        File file = new File("E:\\CashierNewLogins.txt");
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] credentials = line.split(" ");

                String fileCashierID = credentials[0];
                String filePassword = credentials[1];

                if (fileCashierID.equals(CashierID) && filePassword.equals(Password)) {
                    scanner.close();
                    return true;
                }
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PawsShopDashboardDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean check(String ProductID) {
        File file = new File("E:\\PawsShopItems.txt");
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                String[] credentials = line.split(" ");

                String fileProductID = credentials[0];

                if (fileProductID.equals(ProductID)) {
                    scanner.close();
                    return true;
                }
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PawsShopDashboardDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
