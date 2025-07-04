# fawry-rise-ecommerce

A console-based Java application simulating a basic e-commerce system, developed as part of the **Fawry Rise Internship Challenge**.

---

## 🎯 Key Features

* 🛒 **Cart Management** – Add/remove products to cart with quantity tracking.
* 💰 **Balance & Payment** – Validate balance before checkout and debit accordingly.
* 📦 **Shipping Integration** – Adapter-based integration with shipping companies.
* 📢 **Notification System** – Observer pattern to notify via console or logs.
* 📆 **Product Expiry Handling** – Products can be expirable or non-expirable.
* ✅ **Robust Exception Handling** – Custom exceptions for cart, stock, expiry, and balance issues.

---

## 🧠 System Design Overview

The system follows Object-Oriented Programming principles and design patterns:

* **Strategy Pattern** for product expiry behavior (`IExpiry`)
* **Adapter Pattern** for shipping company integration
* **Observer Pattern** for checkout notifications
* **Singleton Pattern** for services like `CheckoutService` and `ShippingService`

---

## 🧩 UML Class Diagram

This diagram illustrates the structure and interaction between core components:

![UML Class Diagram](https://github.com/Mohab-Sobhy/fawry-rise-ecommerce/blob/main/UMLDaigram/ClassDiagram.jpg)

---

## 📁 Project Structure

```
com.mohab.ecommerce
├── exception           # Custom exceptions (e.g., OutOfStockException)
├── expiry              # Expiry-related behaviors (Expirable, NonExpirable)
├── model               # Core business models (Product, Customer, Cart, etc.)
├── notification        # Observer pattern components for notifications
├── service             # Services like checkout and shipping logic
├── shipping            # Shipping company adapter and provider interfaces
└── Util                # Utility classes (e.g., ReceiptFormatter)
```

---

## ⚙️ How to Run

```bash
# Compile
javac -d out src/com/mohab/ecommerce/Main.java

# Run
java -cp out com.mohab.ecommerce.Main
```

---

## 🧾 Sample Output

> Will be shown here if needed — like a receipt or console log

---

## 👤 Author

**Mohab Sobhy**
[GitHub Profile](https://github.com/Mohab-Sobhy)

---

## 📜 License

This project is licensed for educational and internship purposes.
