package market.setting;

import market.SpringTestConfig;
import org.junit.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * Created by CoffeeAndJava on 2017. 4. 21..
 */
public class InheritTest extends SpringTestConfig {
    @Test
    public void inheritTest() throws Exception {
//        mockMvc.perform(get("/child/control")); //.andDo(print());
        mockMvc.perform(get("/control"));
    }
}
