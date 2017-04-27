package market.config;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * Created by CoffeeAndJava on 2017. 4. 12..
 */
@Configuration
//@PropertySource("classpath:application.properties")
public class DBConfig {

//    @Value("${create.sql.file}")
//    private Resource H2_DDL;
//    
//    @Value("${create.sql.file}")
//    private String createSqlFile;
//
//    @Value("${datasource.url}")
//    private String url;
//    
//    @Value("${datasource.username}")
//    private String username;
//    
//    @Value("${datasource.password}")
//    private String password;
//
//    @Value("${datasource.driverClassName}")
//    private String driver;
    
    //jdbc:h2:mem:testdb
//    @Bean
//    public DataSource dataSource() {
//        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//        EmbeddedDatabase db = builder
//        		.setType(EmbeddedDatabaseType.H2)
//        		.addScript(createSqlFile).build();
//        return db;
//    }

	

	@Autowired
	DataSource dataSource;

	@Bean
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return new NamedParameterJdbcTemplate(dataSource);
	}
	
//	@PostConstruct
//	public void startDBManager() {
		
		//hsqldb
		//DatabaseManagerSwing.main(new String[] { "--url", "jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", "" });

		//derby
		//DatabaseManagerSwing.main(new String[] { "--url", "jdbc:derby:memory:testdb", "--user", "", "--password", "" });

		//h2
		//DatabaseManagerSwing.main(new String[] { "--url", "jdbc:h2:mem:testdb", "--user", "sa", "--password", "" });

//	}
	
//    @Bean
//    public DataSource dataSource() {
//        BasicDataSource dataSource = new BasicDataSource();
////        dataSource.setDriverClassName("org.h2.Driver");
////        dataSource.setUrl("jdbc:h2:~/test");
////        dataSource.setUsername("sa");
////        dataSource.setPassword("1234");
////        dataSource.setDefaultAutoCommit(false);
//        
//      dataSource.setDriverClassName(driver);
//      dataSource.setUrl(url);
//      dataSource.setUsername(username);
//      dataSource.setPassword(password);
//
////        return new TransactionAwareDataSourceProxy(dataSource);
//        return dataSource;
//    }

//    @Autowired
//    @Bean
//    public DataSourceInitializer dataSourceInitializer(DataSource dataSource) {
//        final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
//        populator.addScript(H2_DDL);
//
//        final DataSourceInitializer initializer = new DataSourceInitializer();
//        initializer.setDataSource(dataSource);
//        initializer.setDatabasePopulator(populator);
//
//        return initializer;
//    }
}