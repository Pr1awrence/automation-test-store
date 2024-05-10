package pages.product;

import pages.main.MainPage;

public class ArtPage extends ProductListPage {
    @Override
    public void navigateToPage() {
        MainPage mainPage = new MainPage();
        mainPage.clickArtMenuLink();
    }
}
