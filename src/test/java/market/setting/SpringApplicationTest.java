package market.setting;

import market.SpringTestConfig;
import market.service.TestService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by CoffeeAndJava on 2017. 4. 21..
 *
 * 스프링 설정 사용 테스트
 */
public class SpringApplicationTest extends SpringTestConfig {
    @Autowired
    TestService testService;

    @Test
    public void controllerTest() {
        String name = testService.getViewName();
        Assert.assertNotNull(name);
    }
}
