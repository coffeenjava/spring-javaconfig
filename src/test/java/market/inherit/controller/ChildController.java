package market.inherit.controller;

import market.inherit.service.ServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by CoffeeAndJava on 2017. 4. 20..
 */
@Controller
@RequestMapping(value = "/child")
public class ChildController extends ParentController {
//    @Autowired
//    @Qualifier("child")
//    ServiceIF serviceIF;

    @Autowired
    public void setServiceIF(@Qualifier("child") ServiceIF serviceIF) {
        this.serviceIF = serviceIF;
    }

    @Override
    public void inner() {
        System.out.println("Child inner");
        System.out.println(serviceIF.getName());
    }
}