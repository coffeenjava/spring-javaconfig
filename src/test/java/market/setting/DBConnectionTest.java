package market.setting;

import market.SpringTestConfig;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * Created by CoffeeAndJava on 2017. 4. 21..
 * TODO 어플리케이션 구동 시 DB 스키마 생성 sql(resources/market/sql/create.sql) 구동하는 방법 찾기.
 */
public class DBConnectionTest extends SpringTestConfig {
    @Autowired
    private DataSource dataSource;

    @Value("classpath*:create.sql")
    private String H2_DDL;

    @Test
    public void h2DBConnectTest() throws Exception {
        Connection con = dataSource.getConnection();
        Assert.assertNotNull(con);
        System.out.println(H2_DDL);
    }
}
