package Planet4x4;

import RootPage.ParentPage;
import org.openqa.selenium.WebDriver;

public class PageCategory extends ParentPage {

    public PageCategory(WebDriver driver) {
        super(driver);
    }



    public void toReturn() {
        element("//*[@title='Вернуться']").click();
    }






}
