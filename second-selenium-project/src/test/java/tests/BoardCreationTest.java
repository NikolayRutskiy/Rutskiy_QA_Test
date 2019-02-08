package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTest extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    if (!app.getSessionHelper().isUserLoggedIn()) {
      app.getSessionHelper().login();
    }
  }

  @Test
  public void testBoardCreationFromBody() {

    app.getBoardHelper().clickTheCreateNewBoardOnTheEndOfList();

    app.getBoardHelper().addBoardTitle("newBoard" + System.currentTimeMillis());
    app.getBoardHelper().clickTheCreateButton();
    app.returnToPreviousPage();
  }

  @Test
  public void testBoardCreationFromHeader() {
    app.clickOnPlusButtonOnHeader();
    app.getBoardHelper().selectCreateBoard();
    app.getBoardHelper().addBoardTitle("newBoard" + System.currentTimeMillis());
    app.getBoardHelper().clickTheCreateButton();
    app.returnToPreviousPage();

  }
  @Test
  public void testBoardCreationFromBodyWithAllParameters() throws InterruptedException {

    app.getBoardHelper().clickTheCreateNewBoardOnTheEndOfList();
    app.getBoardHelper().addBoardTitle("newBoard" + System.currentTimeMillis());
    app.getBoardHelper().clickTheSelectTeamForCreatingBoard();
    app.getBoardHelper().clickSelectVisibleBoardForCreatingBoard();
    Thread.sleep(3000);
    app.getBoardHelper().chooseVisibleBoard();
    Thread.sleep(3000);
    app.getBoardHelper().clickTheCreateButton();
    app.returnToPreviousPage();
  }
  @Test
  public void test() throws InterruptedException {
    app.getBoardHelper().clickTheCreateNewBoardOnTheEndOfList();
    app.getBoardHelper().clickSelectVisibleBoardForCreatingBoard();
    Thread.sleep(3000);
    app.getBoardHelper().chooseVisibleBoard();
    Thread.sleep(3000);
  }

}
