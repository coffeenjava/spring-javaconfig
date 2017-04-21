package market.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

/**
 * Created by CoffeeAndJava on 2017. 4. 12..
 *
 * TODO 어플리케이션 구동 시 DB 스키마 생성 sql(resources/market/sql/create.sql) 구동하는 방법 찾기.
 */
@Configuration
public class DBConfig {

    @Value("classpath*:create.sql")
    private Resource H2_DDL;

//    @Bean
//    public DataSource dataSourceH2DB() {
//        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//
//        EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.H2).addScript("/market/sql/create.sql").build();
//        return db;
//    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:~/test");
        dataSource.setUsername("sa");
        dataSource.setPassword("1234");
//        dataSource.setDefaultAutoCommit(false);

//        return new TransactionAwareDataSourceProxy(dataSource);
        return dataSource;
    }

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