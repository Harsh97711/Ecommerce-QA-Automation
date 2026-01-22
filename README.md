
🚀 Ecommerce QA Automation Framework

A real-world Selenium Automation Framework built using Java, TestNG, Maven, and Jenkins, designed to automate functional test scenarios for an e-commerce login module.
The framework follows industry best practices like Page Object Model (POM), Data-Driven Testing, and CI/CD Pipeline integration.

🧩 Tech Stack

Programming Language: Java

Automation Tool: Selenium WebDriver

Test Framework: TestNG

Build Tool: Maven

CI/CD Tool: Jenkins

Reporting: Extent Reports (HTML)

Data-Driven Testing: Excel (Apache POI)

Version Control: Git & GitHub

📁 Project Structure
Ecommerce-QA-Automation
│
├── Automation
│   ├── pom.xml
│   ├── testng.xml
│   ├── src
│   │   ├── main
│   │   │   └── java
│   │   │       ├── base
│   │   │       ├── pages
│   │   │       └── utils
│   │   └── test
│   │       └── java
│   │           └── tests
│   └── target
│       └── ExtentReport.html
│
├── Manual_Testing
│   └── TestCases.xlsx
│
└── Jenkinsfile

✅ Key Features

✔ Selenium automation using Page Object Model (POM)

✔ Data-Driven Testing using Excel

✔ Extent HTML Reports with detailed execution results

✔ WebDriverManager for automatic browser driver management

✔ TestNG annotations and assertions

✔ Maven for dependency and build management

✔ Jenkins Freestyle & Pipeline jobs

✔ Jenkinsfile for Pipeline as Code

✔ CI execution with report publishing

▶️ Test Execution
🔹 Run Tests Locally
cd Automation
mvn clean test -Dsurefire.suiteXmlFiles=testng.xml

🔹 Run Tests via Jenkins

Jenkins pulls code from GitHub

Executes Maven TestNG suite

Publishes Extent HTML Report

Shows PASS / FAIL status in Jenkins UI

📊 Reporting

Execution reports generated using Extent Reports

HTML report available at:

Automation/target/ExtentReport.html


Reports are also published directly inside Jenkins

🔄 CI/CD Pipeline

Jenkins Pipeline implemented using Jenkinsfile

Stages include:

Checkout code from GitHub

Run Selenium TestNG automation

Publish HTML reports

Pipeline runs on every manual or scheduled build

🛠 Issues Faced & Solutions (Real Experience)

🔹 ChromeDriver version mismatch → Fixed using WebDriverManager

🔹 Jenkins empty workspace issue → Fixed by correct SCM configuration

🔹 Maven pom.xml path issue → Fixed by aligning repo structure

🔹 HTML report publishing issues → Fixed using Jenkins HTML Publisher

🧠 What I Learned

Building a scalable Selenium automation framework

Handling real-world CI/CD issues in Jenkins

Debugging browser-driver compatibility issues

Using Pipeline as Code (Jenkinsfile)

Writing maintainable automation code using POM

👨‍💻 Author

Harshraj Nikam
QA Automation Engineer
