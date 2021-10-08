package com.example.loyaltycardsystem;

import com.example.loyaltycardsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.spel.spi.EvaluationContextExtension;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserService userService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      /*  auth
                .inMemoryAuthentication()*/
      /*  auth.jdbcAuthentication()
                .dataSource(dataSource)
                .withDefaultSchema()
                .withUser("user")
                .password("{noop}password")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("{noop}admin")
                .roles("USER", "ADMIN")
                .and()
                .withUser("user1")
                .password("{noop}password")
                .roles("USER")
                .and()
                .withUser("user2")
                .password("{noop}password")
                .roles("USER");*/
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      /*  http
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();*/

        http.authorizeRequests().antMatchers("/").permitAll().and()
                .authorizeRequests().antMatchers("/console/**").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers(HttpMethod.POST,"/customers/createCustomer").permitAll()//avoid 401 in postman
                .antMatchers(HttpMethod.GET,"/customers").permitAll()
                .antMatchers(HttpMethod.GET,"/purchases").permitAll()
                .antMatchers(HttpMethod.POST,"/purchases/createPurchase").permitAll()
                .antMatchers(HttpMethod.POST,"/redeemLastPurchase").permitAll()
                .antMatchers(HttpMethod.GET,"/user").permitAll()
                .antMatchers(HttpMethod.POST,"/purchases/createPurchasePost").permitAll()
                .and()
                .authorizeRequests()
                .and().
                authorizeRequests().and()
             .authorizeRequests().antMatchers("/login").permitAll()
                .antMatchers( "/public/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .successHandler(loginSuccessHandler())
                .permitAll()
                //.failureUrl("/login.html?error=true")
                .failureHandler(loginFailureHandler())
                .and()
                .logout()
                .logoutUrl("/perform_logout")
                .deleteCookies("JSESSIONID")
                .logoutSuccessHandler(successLogout());;
        http.csrf().disable();

        http.headers().frameOptions().disable();
    }

    public LogoutSuccessHandler successLogout() {
        return ((request, response, authentication) -> {
            request.changeSessionId();
        });
    }





    public AuthenticationSuccessHandler loginSuccessHandler(){
        return (request, response, authentication) -> {
            request.getSession().setAttribute("flash", new FlashMessage("You are successfully logged in!", FlashMessage.Status.SUCCESS));
            response.sendRedirect("/welcome");//in body of lambda redirect to root of application

        };
    }

    public AuthenticationFailureHandler loginFailureHandler(){
        return (request, response, exception) -> {
            request.getSession().setAttribute("flash",new FlashMessage("Incorrect username and/or password.Please try again!", FlashMessage.Status.FAILURE));
            response.sendRedirect("/login");
        };
    }



}