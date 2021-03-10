package first_test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test2 {
    @Test(dataProvider = "getData")
    public void dataProviderTest(Integer number, String word) {
        System.out.println("" + number + " " + word);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @DataProvider(parallel = false)
    public Object[][] getData() {
        return new Object[][]{
                {1, "one"},
                {2, "two"},
                {3, "three"}
        };
    }
}

