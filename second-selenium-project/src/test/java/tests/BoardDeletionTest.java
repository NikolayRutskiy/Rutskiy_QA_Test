package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.getSessionHelper().isUserLoggedIn()) {
            app.getSessionHelper().login();
            if (app.getBoardHelper().PersonalBoardsCount()==0)
            {
                app.getBoardHelper().createSimpleBoard();
            }
        }
    }



    @Test
    public void deleteFirstBoard() throws InterruptedException {
        int before = app.getBoardHelper().PersonalBoardsCount();
        app.getBoardHelper().clickFirstBoard();
        if(!app.getBoardHelper().isMoreButtonIsVisible()) {
            app.getBoardHelper().clickMenuButton();
        }
        app.getBoardHelper().clickMoreInsideBoard();
        app.getBoardHelper().clickCloseBoard();
        app.getBoardHelper().submitCloseBoard();
        Thread.sleep(2000);
        app.getBoardHelper().returnToMainPage();
        int after = app.getBoardHelper().PersonalBoardsCount();
        Assert.assertEquals(after, before-1);
    }
}
