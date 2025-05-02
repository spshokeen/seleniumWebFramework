# seleniumWebFramework

# Bonify Registration Automation Framework

This is a UI automation framework for testing the registration flow on [https://www.bonify.de](https://www.bonify.de). It's built using Java, Selenium WebDriver, TestNG, and follows the Page Object Model (POM) design pattern with PageFactory.

---

## ⚙️ Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Gradle
- Page Object Model (POM) with PageFactory
- ExtentReports 5
- Faker (for generating test data)
- ThreadLocal WebDriver
- Custom Listeners and Retry Logic
- Config-driven setup
- Screenshot capture on failure
- Parallel test support



---

## 📁 Project Structure

```
src
├── main
│   ├── java
│   │   ├── base           # BaseTest and BasePage
│   │   ├── config         # ConfigReader for reading .properties
│   │   ├── driver         # DriverManager using ThreadLocal
│   │   ├── listeners      # TestNG Listeners and RetryAnalyzer
│   │   ├── pages          # Page classes using PageFactory
│   │   └── utils          # Waits, Faker utils, etc.
│   └──
└── test
    └── java
        └── tests          # TestNG test classes
        
    |_resources
│       └── config.properties
|_suite
  |_ testng.xml   
```

---

## 🔧 How to Set It Up

### 1. git clone

```

### 2. Configure the test credentials
Edit `src/test/resources/config.properties`:

```
base.url=https://www.bonify.de
username=testuser@example.com
password=Test@1234
```

### 3. Run the tests

./gradlew clean test
```

### 4. View test reports
Reports are generated under:
```
test-output/ExtentReport.html
```

---

## ✍️ Writing Tests

You can extend `BaseTest` and use the pre-defined page classes:

```

---

## ✅ Features

- Reusable page objects with clean separation
- Thread-safe WebDriver using ThreadLocal
- Wait utility to reduce flakiness
- Randomized test data using Faker
- ExtentReports integration (v5+)
- Automatic retry for flaky tests
- Configurable URL and credentials

---

## 📌 TODO (Optional Enhancements)
- [ ] Integrate with CI/CD
- [ ] Add browser configuration from CLI

---

## 👨‍💻 Author

Built and maintained by sandeep kumar shokeen 
Email: spshokeen@gmail.com
