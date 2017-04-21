package market.inherit.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * Created by CoffeeAndJava on 2017. 4. 20..
 */
@Service
@Primary // 동일 타입의 빈이 여러개일 경우 반드시 하나를 Primary 로 지정 필요
public class ParentService implements ServiceIF {
    public String getName() {
        return "i am ParentService";
    }
}
