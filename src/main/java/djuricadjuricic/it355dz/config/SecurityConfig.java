package djuricadjuricic.it355dz.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableGlobalMethodSecurity( securedEnabled = true ) //enables securing methods
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    private UserDetailsService userService;
    
    @Autowired //setting up users without database
    public void configureAuth(AuthenticationManagerBuilder auth) throws Exception
    {
//        auth.
//                inMemoryAuthentication().
//                withUser("admin").
//                password("123123").
//                roles("ADMIN").
//                and().
//                withUser("author").
//                password("123123").
//                roles("USER").
//                and().
//                withUser("member").
//                password("123123").
//                roles("MEMBER");
          auth.userDetailsService(userService);
    }

    @Override  //allowing different roles different methods without the @secured
    protected void configure(HttpSecurity http) throws Exception
    {
        http.
                authorizeRequests().
                    antMatchers("/").permitAll().//this mapping is open to anyone
                    antMatchers("/about/").permitAll(). 
                    antMatchers("/authors/").permitAll().
                    antMatchers("/articles/**").hasAnyRole("ADMIN", "AUTHOR", "MEMBER").
                    anyRequest().authenticated().
                    and().
                formLogin().
                    loginPage("/login/").
                    //.usernameParameter("email") incase we need to set a different username parameter
                    failureUrl("/login-error/"). //login-error mapping in Controller returns login.html with a model
                    permitAll().// don't forget permiting all for login
                    and().
                logout().
                    logoutSuccessUrl("/logout/").
                    permitAll();
                
    }
    
    
}
