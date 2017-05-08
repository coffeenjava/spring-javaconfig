package market.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.text.SimpleDateFormat;
import java.util.List;

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
     * InternalResourceViewResolver : war 파일 내에 포함된 view 템플릿 resolve
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

    /**
     * default servlet 매핑 추가 설정
     * WebAppInitializer.java 에 설정된 매핑으로 들어오는 정적 리소스를 handling 할 수 있도록 한다.
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * return Content 미디어 타입 정의
     * SpringMVC 의 미디어 타입 체크 순서
     *  1. URI 확장자
     *  2. Accept in header
     *  3. 기본 설정된 타입
     *
     *  ps) configureMessageConverters() 에서 converter 를 추가한 경우 자동으로 데이터를 확인하여
     *  알맞은 타입으로 resolve 한다. (default 타입은 xml 인듯. Springboot 에서는 json 이라는데..)
     */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        // 요청받은 미디어 타입을 찾지 못할 경우 default 로 json 타입 지정
        // builder 패턴 가능
        configurer.defaultContentType(MediaType.APPLICATION_JSON);
//                .mediaType("xml", MediaType.APPLICATION_ATOM_XML); // 미디어 타입 추가
    }

    /**
     * Message Converter 설정
     * @RequestBody 메서드 파라미터값 / @ResponseBody 메서드 리턴값에 사용할 Converter 를 추가한다.
     * 이 메서드를 구현할 경우 Spring 의 기본 converters 설정은 사라진다.
     *
     * !! 주의 : configureContentNegotiation() 에서 defaultContentType 로 설정된 타입을 추가하지 않을 경우 error
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder()
                .indentOutput(true) // 줄바꿈
                .dateFormat(new SimpleDateFormat("yyyy-MM-dd"));
//                .modulesToInstall(new ParameterNamesModule()); // TODO Module for what?

        /** 설정된 순서대로 판단 **/
        // Json
        converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
        // Xml
        converters.add(new MappingJackson2XmlHttpMessageConverter(builder.xml().build()));
    }

    /**
     * resource 설정
     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/resources/**").addResourceLocations("/public-resources/");
//    }
}
