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

    @DataProvider(name = "colorClothesAccessoriesPagesProvider")
    public Object[][] colorClothesAccessoriesPagesProvider() {
        return new Object[][] {
                {new ClothesPage(), "White", "Color-White"},
                {new ClothesPage(), "Black", "Color-Black"},
                {new AccessoriesPage(), "White", "Color-White"},
                {new AccessoriesPage(), "Black", "Color-Black"}
        };
    }

    @DataProvider(name = "priceSliderRangesProductPagesProvider")
    public Object[][] priceSliderRangesProductPagesProvider() {
        return new Object[][] {
                {new ClothesPage(), "$19.00 - $25.00"},
                {new AccessoriesPage(), "$15.00 - $30.00"},
                {new ArtPage(), "$15.00 - $28.00"}
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
