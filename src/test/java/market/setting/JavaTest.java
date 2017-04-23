package market.setting;

import market.controller.HomeController;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * Created by CoffeeAndJava on 2017. 4. 21..
 *
 * 일반 자바 호출 테스트
 */
public class JavaTest {
    @Test
    public void test() {
        HomeController controller = new HomeController();
        Map map = controller.getMap();
        Assert.assertNotNull(map);
    }
}
