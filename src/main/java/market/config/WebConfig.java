package market.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * dispatcher-servlet.xml
 * web 호출과 관련된 클래스 로딩 및 설정
 */
@Configuration  // config 빈
@EnableWebMvc   // mvc:annotiation-driven > RequestMapping 가능하도록 함
@ComponentScan( // component-scan
    basePackages = {"market"},
    useDefaultFilters = false, // basePackage 하위의 모든 Bean 등록 여부. default=true
    includeFilters = { // 등록할 Bean 지정
        @ComponentScan.Filter(type= FilterType.ANNOTATION, value= Controller.class)
    }
)
public class WebConfig extends WebMvcConfigurerAdapter {
    /**
     * viewResolver 설정
     * InternalResourceViewResolver 를 사용
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

//    @Bean
//    public ViewResolver cnViewResolver(ContentNegotiationManager cnm) {
//        ContentNegotiatingViewResolver cnvr = new ContentNegotiatingViewResolver();
//        cnvr.setContentNegotiationManager(cnm);
//        return cnvr;
//    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

//    @Override
//    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//        configurer.defaultContentType(MediaType.APPLICATION_JSON);
//    }
//
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder()
//                .indentOutput(true)
//                .dateFormat(new SimpleDateFormat("yyyy-MM-dd"));
//        converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
//        converters.add(new MappingJackson2XmlHttpMessageConverter(builder.xml().build()));
//    }
}
