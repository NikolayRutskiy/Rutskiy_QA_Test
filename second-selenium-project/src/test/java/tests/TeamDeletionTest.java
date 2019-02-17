package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamDeletionTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.getSessionHelper().isUserLoggedIn()) {
            app.getSessionHelper().login();
        }
    }
    @Test
    public void deleteFirstTeam()
    {

        app.getTeamHelper().clickFirstTeam();
        app.getTeamHelper().clickSettingsOfTeam();
        app.getTeamHelper().clickDeleteThisTeam();
        app.getTeamHelper().clickDeleteForever();

    }
}
