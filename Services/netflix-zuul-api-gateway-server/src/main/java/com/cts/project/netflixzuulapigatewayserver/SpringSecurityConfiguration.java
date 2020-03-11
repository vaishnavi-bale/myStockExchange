package com.cts.project.netflixzuulapigatewayserver;



import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource dataSource;
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
      http.cors().and().csrf().disable()
        .authorizeRequests()
        .antMatchers("/**").permitAll() 
        .antMatchers("/user-service/login").permitAll()
        .antMatchers("/user-service/**").access("hasRole('USER')")
        .antMatchers("/user-service/user**").access("hasRole('USER')")
        .antMatchers("/user-service/user/**").access("hasRole('USER')")
        .antMatchers("/user-service/main/**").access("hasRole('ADMIN')")
        .and()
        .httpBasic();
    }

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().usersByUsernameQuery("select user_name,password,active from stockuser where user_name=?")
        .authoritiesByUsernameQuery("select user_name,role from stockuser where user_name=?")
        .dataSource(dataSource)
        .passwordEncoder(new PasswordEncoder() {
			
			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				return true;
			}
			
			@Override
			public String encode(CharSequence rawPassword) {
				return rawPassword.toString();
			}
		});
	}
	
	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource configureSource = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfig = new CorsConfiguration();
		corsConfig.setAllowCredentials(true);
		corsConfig.addAllowedOrigin("*");  //add an origin to allow
		corsConfig.addAllowedHeader("*");  //Add an actual request header to allow.
		corsConfig.addAllowedMethod("OPTIONS");
		corsConfig.addAllowedMethod("GET");       //Add an HTTP method to allow
		corsConfig.addAllowedMethod("POST");
		corsConfig.addAllowedMethod("PUT");
		corsConfig.addAllowedMethod("DELETE");
		configureSource.registerCorsConfiguration("/**", corsConfig);
		return new CorsFilter(configureSource	);
	}
	
}
