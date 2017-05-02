package market.setting;

import market.SpringTestConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by CoffeeAndJava on 2017. 4. 21..
 * TODO sql(resources/market/sql/create.sql) properties 외엔 방법 없나?
 */
public class DBConnectionTest extends SpringTestConfig {
	@Autowired
	private DataSource dataSource;
	//
	// @Value("classpath*:create.sql")
	// private String H2_DDL;

	@Test
	public void h2DBConnectTest() throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM user WHERE user_id='lcrapper'");
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		System.out.println("### user_nm => "+rs.getString("user_nm"));
		Assert.assertEquals("이수일킹왕짱",rs.getString("user_nm"));
	}
}
