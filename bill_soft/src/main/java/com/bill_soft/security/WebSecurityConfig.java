package com.bill_soft.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.authorizeRequests().antMatchers("/user/login").permitAll()//
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()//
				.antMatchers("/user/Signup").permitAll()//
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()//
				.antMatchers("/user/addUser").permitAll()//
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()//
				.antMatchers("/user/updateemployeeuser").permitAll()//
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()//
				.antMatchers("/user/bulkUpload-userDetails").permitAll()//
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()//
				.antMatchers("/user/forgot-password").permitAll().antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
				.antMatchers("/addShopDetails").permitAll().antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
				.antMatchers("/user/reset-password").permitAll().antMatchers(HttpMethod.OPTIONS, "/**").permitAll()

				.antMatchers("/user/refreshToken").permitAll()//
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()//
				.anyRequest().authenticated();
		// If a user try to access a resource without having enough permissions
		http.exceptionHandling().accessDeniedPage("/login");
		// http.exceptionHandling().accessDeniedPage("/employeeleave/admin-login");

		// Apply JWT
		http.apply(new JwtTokenFilterConfigurer(jwtTokenProvider));

		// Optional, if you want to test the API from a browser
		// http.httpBasic();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// Allow swagger to be accessed without authentication
		web.ignoring().antMatchers("/v2/api-docs")//
				.antMatchers("/swagger-resources/**")//
				.antMatchers("/swagger-ui.html")//
				.antMatchers("/configuration/**")//
				.antMatchers("/webjars/**")//
				.antMatchers("/public")

				// Un-secure H2 Database (for testing purposes, H2 console shouldn't be
				// unprotected in production)
				.and().ignoring();
		// .antMatchers("/h2-console/**/**");;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12);
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("*"));
		configuration.setAllowedMethods(Arrays.asList("*"));
		configuration.setAllowedHeaders(Arrays.asList("*"));
		configuration.setAllowCredentials(true);
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

}
