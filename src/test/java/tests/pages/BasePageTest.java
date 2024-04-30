package tests.pages;

import core.Hooks;

public class BasePageTest extends Hooks {
    protected String mainPageUrl = reader.getMainPageUrl();
    protected String homePageUrl = reader.getHomePageUrl();
    protected String clothesPageUrl = reader.getClothesPageUrl();
    protected String accessoriesPageUrl = reader.getAccessoriesPageUrl();
    protected String artPageUrl = reader.getArtPageUrl();
    protected String pricesDropPageUrl = reader.getPricesDropPageUrl();
    protected String newProductsPageUrl = reader.getNewProductsPageUrl();
}
