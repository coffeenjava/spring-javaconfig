package market.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * applicationContext.xml
 * web 호출 외의 클래스 로딩 및 설정
 */
@Configuration
@ComponentScan(
    basePackages = {"market"},
    excludeFilters = { // 등록 제외할 Bean 지정
        @ComponentScan.Filter(type= FilterType.ANNOTATION, value= EnableWebMvc.class),
        @ComponentScan.Filter(type= FilterType.ANNOTATION, value= Controller.class)
    }
)
@PropertySource("classpath:application.properties")
public class RootConfig {
	  //To resolve ${} in @Value
  	@Bean
  	public static PropertySourcesPlaceholderConfigurer propertyConfig() {
  		return new PropertySourcesPlaceholderConfigurer();
  	}
}
