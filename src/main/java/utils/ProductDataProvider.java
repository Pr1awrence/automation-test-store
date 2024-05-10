package utils;

import org.testng.annotations.DataProvider;

public class ProductDataProvider {
    @DataProvider(name = "categoryProvider")
    public Object[][] categoryProvider() {
        return new Object[][] {
                {"Men", "Categories-Men"},
                {"Women", "Categories-Women"}
        };
    }

    @DataProvider(name = "sizeProvider")
    public Object[][] sizeProvider() {
        return new Object[][] {
                {"S", "Size-S"},
                {"M", "Size-M"},
                {"L", "Size-L"},
                {"XL", "Size-XL"},
        };
    }
}
