package market.setting;

import market.SpringTestConfig;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created by coffeenjava on 2017. 4. 2..
 *
 * 스프링 웹 어플리케이션 테스트
 */
public class SpringWebApplicationTest extends SpringTestConfig {

    @Test
    public void controllerTest() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/"));

        MvcResult result = resultActions.andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("home"))
                .andExpect(model().attributeExists("title"))
                .andReturn();

//        String content = result.getResponse().getContentAsString();
    }

    @Test
    public void getMapTest() {
        try {
            ResultActions resultActions = mockMvc.perform(get("/getMap").accept(XML_CONTENT));

            MvcResult result = resultActions.andDo(print())
                    .andExpect(status().isOk())
                    .andReturn();

            String content = result.getResponse().getContentAsString();

            System.out.println("--------------");
            System.out.println(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
