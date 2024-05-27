# Test store
This project has been developed to create an automated testing framework for the [test store site](https://teststore.automationtesting.co.uk/index.php), ensuring comprehensive coverage of critical site functions and providing a convenient method for reviewing test results.

### About the project
- Project stack: Java, Selenium, TestNG, Maven, Allure reports
- CI/CD: Jenkins pipeline, [Jenkinsfile](https://github.com/Pr1awrence/automation-test-store/blob/master/Jenkinsfile), and [Github pages](https://pr1awrence.github.io/automation-test-store/) to display Allure reports

### Links:
- [Test documentation](https://docs.google.com/spreadsheets/d/1U8I9o3OmHLU1LQj_cAJqAa_LK4M1uoM15k5TcSO8oRs/edit#gid=0)
- [The latest Allure report](https://pr1awrence.github.io/automation-test-store/)

## Installation
To run the project,  you need to install the software:
- [JDK 17](https://www.oracle.com/java/technologies/downloads/#java17)
- [Maven 3.9.5](https://maven.apache.org/docs/3.9.5/release-notes.html)

After the environment is set up (JAVA_HOME and MAVEN_HOME),
execute the command:
```bash
mvn compile
```

## Usage
To run tests, execute the command:
```bash
mvn test
```

## License

[MIT](https://choosealicense.com/licenses/mit/)