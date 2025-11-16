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
url=https://www.saucedemo.com/
username=standard_user
password=secret_sauce
inputdata=C:\\newSelenium\\NewEcommerceAutomation\\src\\test\\java\\testdata\\InputSheet.xlsx
sheetName=userdata
userdetail=C:\\newSelenium\\NewEcommerceAutomation\\src\\test\\java\\testdata\\userlogin.xlsx
usersheetName=login
```

Modify these values based on your environment.

---

## ▶️ **5. How to Run the Tests**

### **Run using Maven:
* Run using Maven:
mvn clean test
* Run via TestNG XML:
Right click → Run 'testng.xml'
* Run cross‑browser:

In testng.xml, pass browser parameter:

<parameter name="browser" value="firefox" />
## 🧪 6. Automated Test Coverage
Login Tests
Valid login
Invalid username/password
Product Tests
Validate product list visibility
Add item to cart
Validate cart badge number
Checkout Tests
Enter customer info
Validate price and tax
Verify successful order completion

## 🛠 7. Build & Dependencies (pom.xml)

Includes:
Selenium Java
TestNG
WebDriverManager
Apache POI (optional for Excel data)
Extent Reports (optional)

## 📝 8. Enhancements (Optional)

CI/CD integration with Jenkins
Allure/Extent advanced reporting
Retry Analyzer for flaky tests
Dockerized Selenium Grid

## 🧩 9. Sample Test Flow

* Launch browser
* Navigate to SauceDemo
* Login with provided credentials
* Validate product listing
* Add product to cart
* Checkout and place order
* Validate confirmation message


## 🤝 10. Contributions
Feel free to fork the project, add improvements, and create a pull request.

## 📜 License
This project is created for educational and testing purposes.
