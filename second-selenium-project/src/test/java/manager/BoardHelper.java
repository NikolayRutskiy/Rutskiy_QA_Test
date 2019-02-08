package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BoardHelper extends  HelperBase {

  public BoardHelper(WebDriver wd) {
    super(wd);

  }

  public void clickTheCreateNewBoardOnTheEndOfList() {
    WebElement personalBoards = wd.findElement(By.xpath("//*[@class='icon-lg icon-member']/../../.."));
    int boardsCount = personalBoards.findElements(By.xpath(".//*[@class='boards-page-board-section-list-item']")).size();
   personalBoards.findElement(By.xpath(".//*[@class='boards-page-board-section-list-item']["+(boardsCount)+"]")).click();

  }

  public void addBoardTitle(String boardName) {
    type(By.cssSelector("input.subtle-input"), boardName);
  }

  public void clickTheCreateButton() {
    click(By.cssSelector("[type=submit]"));
  }

  public void selectCreateBoard() {
    click(By.cssSelector(".js-new-board"));
  }

  public void clickTheSelectTeamForCreatingBoard() {
    click(By.cssSelector(".org-chooser-trigger"));
    click(By.xpath("//ul[contains(@class,'org-chooser')]//li[3]"));
  }

  public void clickSelectVisibleBoardForCreatingBoard() {
    click(By.cssSelector(".vis-chooser-trigger"));
  }

  public void chooseVisibleBoard() {
    click(By.xpath("//span[text()='Private']/.."));
  }
}
