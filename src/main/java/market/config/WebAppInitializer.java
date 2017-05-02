package market.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

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
     * servlet 매핑 설정
     */
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }


    /********** 추가 설정 **************************************************/

    /**
     * Filter 적용
     */
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        return new Filter[] {characterEncodingFilter};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        // multipart
//        registration.setMultipartConfig(
//            // 최대 파일 크기, 전체 요청 최대 크기, 임시 저장위치 쓰지 않고 업로드할 수 있는 파일 최대 크기(def:0) 등 설정 가능
//            new MultipartConfigElement("[upload folder name]")
//        );
    }
}
