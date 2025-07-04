# fawry-rise-ecommerce

A console-based Java application simulating a basic e-commerce system, developed as part of the **Fawry Rise Internship Challenge**.

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
javac --release 17 -d out $(find src -name "*.java")

# Run
java -cp out com.mohab.ecommerce.Main
```

---

## 🧾 Sample Output

![Sample Output](https://github.com/Mohab-Sobhy/fawry-rise-ecommerce/raw/main/Screenshot/screenshot.png)

---

## 👤 Author

**Mohab Sobhy**
[GitHub Profile](https://github.com/Mohab-Sobhy)

---

## 📜 License

This project is licensed for educational and internship purposes.
