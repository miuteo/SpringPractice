//package springInAction.springOnTheWeb.buildingSpringWebApp;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
//
///**
// * Created by teodor.miu on 13-Jun-17.
// */
//@Configuration
//@EnableWebSecurity
//public class SecuriyConfig extends WebSecurityConfigurerAdapter{
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth)throws Exception{
//        auth.inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER")
//                .and()
//                .withUser("admin").password("password").roles("ADMIN","USER");
//
//    }
//    @Override
//    protected void configure(HttpSecurity http)throws Exception{
//        http.formLogin()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/spitter/me").hasRole("SPITTER")
//                .antMatchers(HttpMethod.POST,"/spittles").hasRole("SPITTER")
//                .anyRequest().permitAll()
//                .and().requiresChannel().antMatchers("/spitter/register").requiresSecure();
//
//    }
//}
