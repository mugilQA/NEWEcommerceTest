# NEWEcommerceTest
# 🚀 Selenium Automation Framework for SauceDemo

This repository contains a **modular, scalable, and maintainable Selenium Automation Framework** designed for testing the **SauceDemo** sample e-commerce application.

🔗 **Test Website:** [https://www.saucedemo.com/](https://www.saucedemo.com/)

---

## 📌 **1. Framework Overview**

This automation framework is built using:

* **Java** (OOP-focused programming)
* **Selenium WebDriver**
* **TestNG** for test management
* **Page Object Model (POM)** for maintainable test scripts
* **Maven** for dependency management

The goal is to provide an end-to-end testing solution covering login, product selection, cart validation, checkout workflow, and logout.

---

## 📁 **2. Project Structure**

```
src/main/java
│
├── base/
│    ├── BaseTest.java
│
├── pagesource/
│    ├── Login.java
│    ├── Product.java
│    ├── Cart.java
│    └── Checkout.java
│
├── utils/
│    ├── ConfigReader.java
|    ├── DataProviderUtil.java
│    ├── ExtentManager.java
│    ├── ExtentTestListener.java
│    └── FetchExcel.java
|    ├── ReuseUtility.java
|    ├── Retryanalyzer.java
|    
│
├── tests/java
│    ├── LoginAppliation.java
│    ├── Productapplication.java
│    ├── CheckoutApplication.java
│    └── CartApplication.java
│
└── resources/
     ├── config.properties
     └── testdata.xlsx

testng.xml
pom.xml
```

---

## ⚙️ **3. Key Features**

### ✔ Page Object Model (POM)

Separates UI locators and actions from test logic.

### ✔ OOP Concepts

* **Inheritance** → BaseTest, BasePage
* **Encapsulation** → Private locators, public methods
* **Polymorphism** → Browser setup via DriverFactory
* **Abstraction** → Common utilities (waits, screenshots)

### ✔ TestNG Integration

* Test lifecycle management
* DataProvider for login scenarios
* Grouping, parallel execution, assertions

### ✔ Utilities

* Centralized config handling
* Explicit wait wrapper
* Screenshot capturing on failures
* Cross-browser execution (Chrome, Firefox, Edge)

### ✔ Reporting

* TestNG HTML default report
* Extent report
* Listener

---

## 🔧 **4. Configuration**

The `config.properties` file stores:

```
baseUrl=https://www.saucedemo.com/
browser=chrome
username=standard_user
password=secret_sauce
implicitWait=10
explicitWait=15
```

Modify these values based on your environment.

---

## ▶️ **5. How to Run the Tests**

### **Run using Maven:
