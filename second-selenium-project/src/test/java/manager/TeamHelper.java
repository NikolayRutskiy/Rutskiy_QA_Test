package manager;

import model.Team;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TeamHelper extends HelperBase{
  private WebDriver wd;

  public TeamHelper(WebDriver wd) {
    super(wd);
  }


  public void clickOnCreateTeamButtonOnNavMenu() {
    click(By.cssSelector("[data-test-id='home-navigation-create-team-button']"));
  }

  public void fillTeamCreationForm(Team team) {
    type(By.id("org-display-name"), team.getTeamName());
    type(By.id("org-desc"), team.getDescription());
  }

  public void submitTeamCreationForm() {
    click(By.xpath("//*[@value='Create']"));
  }

  public void clickFirstTeam() {
    click(By.xpath("//span[@data-test-id='home-team-tab-name']"));
  }

  public void clickSettingsOfTeam() {
    click(By.xpath("//span[text()='Settings']"));
  }

  public void clickDeleteThisTeam() {
    click(By.xpath("//span[text()='Delete this team?']"));
  }

  public void clickDeleteForever() {
    click(By.xpath("//input[@value='Delete Forever']"));
  }


}
