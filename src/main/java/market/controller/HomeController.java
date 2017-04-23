package market.controller;

import market.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by coffeenjava on 2017. 3. 20..
 */
@Controller
//@RestController // @Controller + @ResponseBody
public class HomeController {
    @Autowired
    TestService testService;

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("title", "HelloTitle");
//        return "home";
        return testService.getViewName();
    }

    @GetMapping("/getMap") // == @RequestMapping(value="/getMap", method= RequestMethod.GET)
    @ResponseBody
    public Map getMap() {
        Map<String,String> m = new HashMap<>();
        m.put("name","brian");
        m.put("age","38");
        return m;
    }
}