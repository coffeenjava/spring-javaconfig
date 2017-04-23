package market.config;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by coffeenjava on 2017. 4. 15..
 *
 * 사용하지 않음.
 * DispatcherServlet 이 아닌 그외 서블릿/필터에 대한 설정이 필요한 경우 구현
 */
public class ServletInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        /** 추가 서블릿 설정 **/
//        ServletRegistration.Dynamic servlet = servletContext.addServlet("myServlet", MyServlet.class);
//        servlet.addMapping("/myPath/**");

        /** 필터 설정 **/
//        FilterRegistration.Dynamic filter = servletContext.addFilter("myFilter", MyFilter.class);
//        filter.addMappingForUrlPatterns(null, false, "/myPath/*");
    }
}
