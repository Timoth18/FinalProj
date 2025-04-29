# FinalProj - Automation Test Framework

## 📌 Tools Used
- Java 17
- Cucumber + Gherkin
- Selenium WebDriver
- RestAssured
- Gradle
- GitHub Actions

## 🧪 How to Run

### API Tests
```bash
./gradlew apiTest
```

### Web UI Tests
```bash
./gradlew webTest
```

## ✅ Tags
- `@api` for API tests
- `@web` for UI tests

## 📂 Reports
- HTML and JSON reports will be generated in `cucumber-report/` folder.

## 🔁 CI/CD
- Workflow runs on PR, push to `main`, and manual trigger via GitHub Actions.