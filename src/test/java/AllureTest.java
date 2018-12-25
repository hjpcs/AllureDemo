import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class AllureTest {

    @Test
    @DisplayName("demo1 displayname")
    @Description("Allure test")
    @Link("https://www.testerhome.com/")
    @Issue("110")
    @Severity(SeverityLevel.MINOR)
    public void demo1() {
        login();
        login();
        login();

        StepResult stepResult = new StepResult();
        stepResult.setStatus(Status.FAILED);
        stepResult.setName("new step name");
        Allure.getLifecycle().startStep("new step", stepResult);
        Allure.getLifecycle().stopStep();

        assertThat(1, equalTo(2));
        login();
    }

    @Step("login step name")
    public void login() {
        System.out.println("login step");
        try {
            Allure.addAttachment("demo picture", "image/jpg",
                    new FileInputStream("C:\\Users\\hejp25215\\Pictures\\1.jpg"), ".jpg");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void demo2() {
        assertThat(2, equalTo(2));
    }

    @Test
    public void demo3() {
        assertThat(3, equalTo(2));
    }
}
