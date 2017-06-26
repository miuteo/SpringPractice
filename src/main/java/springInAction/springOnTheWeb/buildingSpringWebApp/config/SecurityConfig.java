package springInAction.springOnTheWeb.buildingSpringWebApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import springInAction.springOnTheWeb.buildingSpringWebApp.data.SpitterRepository;
import springInAction.springOnTheWeb.buildingSpringWebApp.data.SpitterUserService;

/**
 * Created by teodor.miu on 22-Jun-17.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    private final SpitterRepository spitterRepository;

    public SecurityConfig(SpitterRepository spitterRepository){
        this.spitterRepository = spitterRepository;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.formLogin()
                .loginPage("/login")
                .and()
                .logout().logoutUrl("logout").logoutSuccessUrl("/")
                .and()
                .rememberMe().tokenRepository(new InMemoryTokenRepositoryImpl())
                            .tokenValiditySeconds(2419200)
                            .key("spitterKey")
                .and()
                .httpBasic().realmName("Spitter")
                .and()
                .authorizeRequests().antMatchers("/").authenticated()
                                    .antMatchers("/spitter/me").authenticated()
                                    .antMatchers(HttpMethod.POST,"/spittles").authenticated()
                                    .anyRequest().permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
//                .inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER");
        .userDetailsService(new SpitterUserService(spitterRepository));
    }



}
