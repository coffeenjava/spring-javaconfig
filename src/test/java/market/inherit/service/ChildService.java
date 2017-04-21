package market.inherit.service;

import org.springframework.stereotype.Service;

/**
 * Created by CoffeeAndJava on 2017. 4. 20..
 */
@Service("child")
public class ChildService extends ParentService {

    @Override
    public String getName() {
        return "i am ChildService";
    }
}
