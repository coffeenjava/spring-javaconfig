package market;

import market.config.RootConfig;
import market.config.WebConfig;
import market.controller.HomeController;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by CoffeeAndJava on 2017. 4. 21..
 *
 * 스프링 설정 사용 테스트용
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class, WebConfig.class}) // 루트 context, 웹 context 사용
public class SpringTestConfig {
    protected MockMvc mockMvc;


    @Before
    public void before() {
        /**
         * stand alone
         * without @ setting
         */
        mockMvc = MockMvcBuilders.standaloneSetup(new HomeController()).build();
    }
}
