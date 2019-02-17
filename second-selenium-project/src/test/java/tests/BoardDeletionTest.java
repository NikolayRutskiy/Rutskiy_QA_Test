package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.getSessionHelper().isUserLoggedIn()) {
            app.getSessionHelper().login();
            if (app.getBoardHelper().PersonalBoardsCount()==0)
            {
               app.getBoardHelper().clickTheCreateNewBoardOnTheEndOfList();
                app.getBoardHelper().addBoardTitle("newBoard" + System.currentTimeMillis());
                app.getBoardHelper().clickTheCreateButton();
           }
        }
    }
    @Test
    public void deleteFirstBoard()
    {
        app.getBoardHelper().clickFirstBoard();
        app.getBoardHelper().clickMenuButton();
        app.getBoardHelper().clickMoreInsideBoard();
        app.getBoardHelper().clickCloseBoard();
        app.getBoardHelper().submitCloseBoard();
    }
}
