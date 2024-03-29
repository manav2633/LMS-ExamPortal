package com.exam.portal.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.exam.portal.OrganiserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource datasource;
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new OrganiserDetailsService();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider=new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http
<<<<<<< HEAD
		.csrf().disable()
=======
	        .csrf().disable()
>>>>>>> 9df55da712840a4bbaf364f7489758dc0b9f61eb
	        .authorizeRequests()
	            .antMatchers("/organiser/register").permitAll()
				.antMatchers("/student/add","/student/getAll").permitAll()
	            .antMatchers("/organiser/**").authenticated()
	            .and()
	        .formLogin()
	            .loginPage("/organiser/login")
	            .usernameParameter("email")
	            .passwordParameter("password")
	            .loginProcessingUrl("/organiser/login")
	            .defaultSuccessUrl("/organiser/dashboard")
	            .permitAll()
	            .and()
	        .headers()
	            .contentSecurityPolicy("frame-ancestors 'self'")
	            .and().and()
	        .logout()
	            .logoutRequestMatcher(new AntPathRequestMatcher("/organiser/logout"))
	            .logoutSuccessUrl("/organiser/login?logout")
	            .permitAll();
	}


}
