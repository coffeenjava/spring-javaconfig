package market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import market.model.User;
import market.service.UserService;

/**
 * Created by lcrapper on 2017. 4. 25..
 */
@Controller
//@RestController // @Controller + @ResponseBody
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value="/user", method= RequestMethod.GET)
    public User getUser(Model model, String userId) {
        model.addAttribute("title", "user");
        User user = userService.getUser(userId);
        model.addAttribute("user", user);
        return user;
    }

}