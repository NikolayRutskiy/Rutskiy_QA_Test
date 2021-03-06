package manager;

import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {
    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToPreviousPage() {
        wd.navigate().back();
    }
}
