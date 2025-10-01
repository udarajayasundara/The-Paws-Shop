# 🐾 The Paws Shop Management System

A desktop application designed for managing inventory, sales, and user accounts within a pet supplies store, "The Paws Shop."

This project uses **Java Swing/AWT** for the graphical user interface (GUI) and is structured for use within the **NetBeans IDE**.

---

## 🌟 Key Features

The application is built around a secure, role-based system to manage all aspects of the shop's operations:

### 👤 User & Access Control
* **Role-Based Login:** Separate interfaces for Managers and Cashiers.
* **User Creation:** Managers can register new Cashier accounts.

### 📦 Inventory & Supplies Management
* **Add New Item:** Register new pet supplies with details (ID, name, price, stock).
* **Update Item:** Modify the details of existing supplies.
* **Delete Item:** Remove items from the inventory.
* **Search Item:** Quickly locate a supply item by ID or name.
* **View Inventory:** Display a list of all current pet supplies and stock levels.

### 💾 Data Persistence
* All item and user data is stored in local **flat files** (e.g., `PawsShopItems.txt`, `CashierNewLogins.txt`).

---

## 🛠️ Technologies Used

* **Language:** Java
* **GUI Toolkit:** Java Swing / AWT
* **Development Environment:** NetBeans IDE
* **Data Storage:** Local Text Files (.txt)

---

## 🚀 Getting Started

### Prerequisites

To compile and run this project, you need:

1.  **Java Development Kit (JDK)** (version 8 or later is recommended).
2.  **NetBeans IDE** (The project structure is optimized for this environment).

### Setup and Execution (NetBeans)

1.  **Clone the Repository:**
    ```bash
    git clone [https://github.com/udarajayasundara/The-Paws-Shop.git](https://github.com/udarajayasundara/The-Paws-Shop.git)
    ```
2.  **Open in NetBeans:**
    * Open NetBeans IDE.
    * Go to **File** -> **Open Project**.
    * Navigate to the cloned `The-Paws-Shop` directory and open it.
3.  **Run:**
    * Right-click the project name in the Projects window.
    * Select **Run**. The Login Interface should appear.

### Default Login Credentials

Use these credentials to test the role-based access:

| Role | Username | Password | Access Interface |
| :--- | :------- | :------- | :--------------- |
| **Manager** | `manager` | `12345` | PawsShopDashboard (Full Control) |
| **Cashier** | `cashier` | `12345` | PawsShopDashboardCashier (Limited Control) |

*(Note: These default credentials are hardcoded or stored in the plain text files `CashierNewLogins.txt` or similar files within the project.)*

---

## 📂 Project Structure Overview

The project is organized in a standard NetBeans Java application structure:

The Paws Shop/
├── build/                 # Compiled .class files (auto-generated)
├── nbproject/             # NetBeans project configuration files
├── src/                   # Source code directory
│   ├── DataBase/          # Classes for file I/O (Database operations)
│   ├── ShopUI/            # GUI forms and logic for Item Management
│   │   ├── AddNewPetSupplies.java
│   │   ├── DeletePetSupplies.java
│   │   └── ...
│   └── User/              # GUI forms and logic for User Management
│       ├── LoginInterface.java
│       ├── ManagerInterface.java
│       └── ...
├── CashierNewLogins.txt   # Stores Cashier account credentials
├── PawsShopItems.txt      # Stores the main item inventory data
└── manifest.mf            # JAR manifest file


---

## ✍️ Author

* **GitHub:** [udarajayasundara](https://github.com/udarajayasundara)
