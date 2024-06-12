package utils;

import org.testng.annotations.DataProvider;

public class RegistrationDataProvider {
    @DataProvider(name = "validFirstAndLastNamesProvider")
    public Object[][] validFirstAndLastNamesProvider() {
        return new Object[][] {
                {"John", "Smith"},
                {"John Adam", "Smith Jr"}, // dash
                {"John . Adam", "Smith Jr."}, // dot
        };
    }

    @DataProvider(name = "invalidFirstAndLastNamesProvider")
    public Object[][] invalidFirstAndLastNamesProvider() {
        return new Object[][] {
                {"1", "2"},
                {"John.Adam", "Smith.Jr."}, // dot

                /*
                * FIXME: Bug ID: 8 (empty first or last name)
                *  {"", ""}
                * */
        };
    }

    @DataProvider(name = "validPasswordsProvider")
    public Object[][] validPasswordsProvider() {
        return new Object[][] {
                {"password123"}, // simple pass
                {"Pa$$w0rd!@#2024"}, // difficult pass with special characters
                {"pass word with spaces"},
                {"Pässwørd2024"} // unicode pass
        };
    }

    @DataProvider(name = "invalidPasswordsProvider")
    public Object[][] invalidPasswordsProvider() {
        return new Object[][] {
                {"abc"}, // short pass
                {"aVeryLongPasswordThatExceedsNormalLengthExpectationsAndTestsTheLimitsOfTheSystem"}, // long pass

                /*
                * FIXME: Bug ID: 7 (empty password)
                *  {""}
                * */

                /*
                * FIXME: Tech ID: 2 (I don't include these checks as they are not coordinated with the site owner)
                * {"'; DROP TABLE users; --"} // SQL Injection
                * {"<script>alert('XSS')</script>"} // XSS
                * */
        };
    }

    @DataProvider(name = "validBirthDatesProvider")
    public Object[][] validBirthDatesProvider() {
        return new Object[][] {
                {"05/01/1980"},
                {"12/31/2022"},
                {""}
        };
    }

    @DataProvider(name = "invalidBirthDatesProvider")
    public Object[][] invalidBirthDatesProvider() {
        return new Object[][] {
                {"0000"},
                {"31/12/2023"},
                {"12.31.2023"},
                {"abcd"}
        };
    }
}