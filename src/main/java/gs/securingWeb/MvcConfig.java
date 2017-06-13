package gs.securingWeb;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by teodor.miu on 13-Jun-17.
 */
@Configuration
public class MvcConfig  extends WebMvcConfigurerAdapter {
    private final static String PATH="/gs/securingWeb/";
    @Override
    public void addViewControllers(ViewControllerRegistry  registry){
        registry.addViewController("/home").setViewName(PATH+"home");
        registry.addViewController("/").setViewName(PATH+"home");
        registry.addViewController("/hello").setViewName(PATH+"hello");
        registry.addViewController("/login").setViewName(PATH+"login");
    }
}
