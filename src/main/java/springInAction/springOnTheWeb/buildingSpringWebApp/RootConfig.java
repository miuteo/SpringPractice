package springInAction.springOnTheWeb.buildingSpringWebApp;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Asus x556 on 06-Jun-17.
 */
@Configuration
@ComponentScan(basePackages="springInAction.springOnTheWeb.buildingSpringWebApp",
excludeFilters =@ComponentScan.Filter(type= FilterType.ANNOTATION,value= EnableWebMvc.class))
public class RootConfig {

}
