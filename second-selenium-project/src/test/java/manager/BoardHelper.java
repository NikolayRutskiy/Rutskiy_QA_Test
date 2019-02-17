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

  public int PersonalBoardsCount(){
    WebElement personalBoards =
            wd.findElement(By.xpath("//*[@class='icon-lg icon-member']/../../.."));
    return
            personalBoards.findElements(By.xpath(".//*[@class='boards-page-board-section-list-item']")).size()-1;
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

  public void clickFirstBoard() {
    click(By.xpath("//*[@class='icon-lg icon-member']/../../..//*[@class='boards-page-board-section-list-item'][1]"));
  }

  public void clickMoreInsideBoard() {
    click(By.xpath("//span[@class='icon-sm icon-overflow-menu-horizontal board-menu-navigation-item-link-icon']"));
  }

  public void clickCloseBoard() {
    click(By.xpath("//a[@class=\'board-menu-navigation-item-link js-close-board\']"));
  }

  public void submitCloseBoard() {
    click(By.xpath("//input[@value='Close']"));
  }

  public void clickMenuButton() {
    click(By.xpath("//span[text()='Show Menu']"));
  }

    public boolean isMoreButtonIsVisible() {
      return isElementPresent(By.xpath("//span[@class='icon-sm icon-overflow-menu-horizontal board-menu-navigation-item-link-icon']"));
    }
  public void createSimpleBoard() {
    clickTheCreateNewBoardOnTheEndOfList();
    addBoardTitle("newBoard" + System.currentTimeMillis());
    clickTheCreateButton();
  }
}
