package market.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * web.xml
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * applicationContext.xml 으로 사용할 class 설정
     * 구현 필수
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootConfig.class };
    }

    /**
     * dispatcher-servlet.xml 로 사용할 class 설정
     * 구현 필수
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }

    /**
     * 기본 dispatcherServlet 매핑 설정
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        return new Filter[] {characterEncodingFilter};
    }
}
