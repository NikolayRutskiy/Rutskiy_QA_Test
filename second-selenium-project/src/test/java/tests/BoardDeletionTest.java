package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.getSessionHelper().isUserLoggedIn()) {
            app.getSessionHelper().login();
        }
    }
    @Test
    public void deleteFirstBoard()
    {
        app.getBoardHelper().clickFirstBoard();
        app.getBoardHelper().clickMoreInsideBoard();
        app.getBoardHelper().clickCloseBoard();
        app.getBoardHelper().submitCloseBoard();
    }
}
