package market.inherit.controller;

import market.inherit.service.ServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by CoffeeAndJava on 2017. 4. 20..
 */
@Controller
public class ParentController {
    @Autowired
    ServiceIF serviceIF;

    @RequestMapping(method = RequestMethod.GET, value= "/control")
    public void control() {
        String name = this.serviceIF.getName();
        System.out.println(name);
//        inner();
    }

    public void inner() {
        System.out.println("Parent inner");
        System.out.println(serviceIF.getName());
    }
}