# TeachUA Test Automation Project

This repository contains automated tests for the **TeachUA platform**, developed as part of a test automation course. The project uses Java, Selenium WebDriver, JUnit 5, and the Page Object Model (POM) design pattern.

## Project Features

- **Parameterized Tests**: Test multiple data sets using JUnit's `@ParameterizedTest` and `@MethodSource`.
- **Page Object Model**: Structured code for better reusability and maintainability.
- **Modular Test Data**: Includes predefined data for cities, clubs, challenges, and comments.
- **Comprehensive Test Coverage**:
  - **Challenge Page Tests**: Verify YouTube video frames and challenge-specific functionality.
  - **Club Page Tests**: Validate advanced search, city filters, and club comments.

---

## Test Scenarios

### 1. Challenge Page
- Verify the YouTube frame is displayed for specific challenges.
- Check video content for predefined URLs.
  
### 2. Club Page
- Verify clubs are filtered by city.
- Check club details and advanced search functionality.
- Validate comments for specific clubs.

### 3. Cities and Comments
- Ensure club addresses match the selected city.
- Verify comments are correctly displayed on club detail pages.

---

## File Structure

```
src/
└── test/
    └── java/
        └── com/
            └── softserve/
                ├── data/          # Predefined test data
                │   ├── Cities.java
                │   ├── Challengies.java
                │   ├── ClubContents.java
                │   └── CommentContents.java
                ├── pages/         # Page Object classes
                │   ├── challenge/
                │   │   ├── ChallengePage.java
                │   │   ├── ChallengeTeachPage.java
                │   │   └── YoutubeFrame.java
                │   └── club/
                │       ├── AdvancedClubPage.java
                │       ├── ClubComponent.java
                │       ├── ClubDetailsPage.java
                │       └── ClubPage.java
                └── tests/         # Test classes
                    ├── SomeTest.java
                    └── TestRunner.java
```

---

## How to Run Tests

1. **Clone the Repository**:
   ```bash
   git clone <repository-url>
   cd <repository-folder>
   ```

2. **Set up Dependencies**:
   Ensure you have Maven installed, then execute:
   ```bash
   mvn clean install
   ```

3. **Run Tests**:
   To execute all tests:
   ```bash
   mvn test
   ```

---

## Dependencies

- **Java**: Version 17 or higher.
- **Maven**: For managing dependencies and running tests.
- **Libraries**:
  - Selenium WebDriver
  - JUnit 5
  - WebDriverManager

---

## Key Highlights

- **Reusable Components**: The Page Object Model simplifies test maintenance.
- **Data-Driven Testing**: Test data is managed in a modular format for flexibility.
- **Robust Assertions**: Uses JUnit assertions to verify test results.

---

## Acknowledgments

This project was created as part of the **SoftServe Test Automation Course**. Special thanks to the mentors and instructors for their guidance.
