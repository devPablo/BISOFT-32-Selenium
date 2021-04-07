package Google;

import org.testng.annotations.Test;

public class TestGooglePage extends BaseTest {
    @Test
    public void primerTest()
    {
        GHP.clickGoogle("Universidad Cenfotec");
    }

}
