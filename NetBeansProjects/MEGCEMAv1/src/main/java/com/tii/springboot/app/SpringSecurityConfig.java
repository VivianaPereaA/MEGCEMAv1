package com.tii.springboot.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{

       /* http.authorizeRequests().antMatchers("/", "/css/**", "/js/**").permitAll()
        .antMatchers("/verPaciente/**").hasAnyRole("USER")
        .antMatchers("/form/**").hasAnyRole("USER")
        .antMatchers("/eliminar/**").hasAnyRole("ADMIN")
        .antMatchers("/factura/**").hasAnyRole("ADMIN")
        .antMatchers("/verPaciente/**").hasAnyRole("ADMIN")*/
        //http.anyRequest().authenticated();
        
        http.authorizeRequests().
               antMatchers("/css/**","/js/**","/img/**","/").permitAll()
        .anyRequest().permitAll()//si es autenticado .authenticated()
        .and()
          .formLogin().loginPage("/login")
                .permitAll()
          .and()
          .logout().permitAll();
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Autowired
    public void configureGlobal (AuthenticationManagerBuilder builder) throws Exception{
        
        PasswordEncoder encoder = passwordEncoder();
        UserBuilder users = User.builder().passwordEncoder(encoder::encode);

        builder.inMemoryAuthentication()
        .withUser(users.username("administrador").password("12345").roles("ADMIN","USER"))
        .withUser(users.username("paciente").password("12345").roles("USER"))
        .withUser(users.username("recepcionista").password("12345").roles("USER"))
        .withUser(users.username("medico").password("12345").roles("USER"))
         ;
    }
}
