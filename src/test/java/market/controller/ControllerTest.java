package market.controller;

import market.config.RootConfig;
import market.config.WebConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


/**
 * Created by coffeenjava on 2017. 4. 2..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class, WebConfig.class})
public class ControllerTest {

    MockMvc mockMvc;
    @Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    HomeController homeController;

    @Before
    public void before() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void test() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.view().name("home"))
                .andReturn();
        String content = result.getResponse().getContentAsString();
        System.out.println("["+content+"]");
    }

    @Test
    public void getMapTest() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/getMap"));
        MvcResult result = resultActions.andReturn();
        String content = result.getResponse().getContentAsString();
        System.out.println(content);
    }
}
