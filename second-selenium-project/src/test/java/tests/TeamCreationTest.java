package tests;

import model.Team;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TeamCreationTest extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    if (!app.getSessionHelper().isUserLoggedIn()) {
      app.getSessionHelper().login();
    }
  }
  @DataProvider
  public Iterator<Object[]> validGroups(){
    List<Object[]> list = new ArrayList<>();
    list.add(new Object[] {"teamName1", "QA group"});
    list.add(new Object[] {"teamName2", "Developer group"});
    list.add(new Object[] {"teamName3", "Manager group"});
    return list.iterator();
  }
  @Test(dataProvider = "validGroups")
  public  void teamCreationFromLeftNavMenu(String name, String description){
    app.getTeamHelper().clickOnCreateTeamButtonOnNavMenu();
    app.getTeamHelper().fillTeamCreationForm(new Team()
            .withTeamName(name)
            .withDescription(description));
    app.getTeamHelper().submitTeamCreationForm();
  }
  @DataProvider
  public Iterator<Object[]> validGroups1() throws IOException {
    List<Object[]> list = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/teams.csv")));
    String line = reader.readLine();
    while(line!=null)
    {
      String[] split = line.split(";");
      list.add(new Object[] {new Team().withTeamName(split
              [0]).withDescription(split[1])});
      line=reader.readLine();
    }
    return list.iterator();
  }
  @Test(dataProvider = "validGroups1")
  public  void teamCreationFromLeftNavMenuUsingDataFile(Team team){
    app.getTeamHelper().clickOnCreateTeamButtonOnNavMenu();
    app.getTeamHelper().fillTeamCreationForm(team);
    app.getTeamHelper().submitTeamCreationForm();
  }
  @AfterMethod
  public void postAction()
  {
    app.getNavigationHelper().returnToPreviousPage();
  }

}
