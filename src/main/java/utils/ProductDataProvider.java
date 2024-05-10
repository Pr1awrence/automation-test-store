package utils;

import org.testng.annotations.DataProvider;
import pages.product.AccessoriesPage;
import pages.product.ArtPage;
import pages.product.ClothesPage;

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

    @DataProvider(name = "productListPages")
    public Object[] productListPages() {
        return new Object[] {
                new ClothesPage(),
                new AccessoriesPage(),
                new ArtPage()
        };
    }

    @DataProvider(name = "productListClothesAccessoriesPages")
    public Object[] productListClothesAccessoriesPages() {
        return new Object[] {
                new ClothesPage(),
                new AccessoriesPage()
        };
    }

    @DataProvider(name = "productListAccessoriesArtPages")
    public Object[] productListAccessoriesArtPages() {
        return new Object[] {
                new AccessoriesPage(),
                new ArtPage()
        };
    }
}
