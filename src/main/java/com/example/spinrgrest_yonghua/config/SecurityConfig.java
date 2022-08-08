package com.example.spinrgrest_yonghua.config;

import com.example.spinrgrest_yonghua.security.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.http.HttpServletResponse;

@Configuration
//@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private JwtFilter jwtFilter;

	@Autowired
	public void setJwtFilter(JwtFilter jwtFilter) {
		this.jwtFilter = jwtFilter;
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http
//				.csrf().disable()
//				.addFilterAfter(jwtFilter, UsernamePasswordAuthenticationFilter.class)
//				.authorizeRequests()
//				.antMatchers("/user/test").permitAll()
//				.antMatchers("/content/getAll", "/content/get/*").hasAuthority("read")
//				.antMatchers("/content/create").hasAuthority("write")
//				.antMatchers("/content/update").hasAuthority("update")
//				.antMatchers("/content/delete/*").hasAuthority("delete")
//				.anyRequest()
//				.authenticated();
		// Enable CORS and disable CSRF
		http = http.cors().and().csrf().disable();

		// Set session management to stateless
		http = http
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and();

		// Set unauthorized requests exception handler
		http = http
				.exceptionHandling()
				.authenticationEntryPoint(
						(request, response, ex) -> {
							response.sendError(
									HttpServletResponse.SC_UNAUTHORIZED,
									ex.getMessage()
							);
						}
				)
				.and();

		// Set permissions on endpoints
//		.antMatchers("/content/getAll", "/content/get/*").hasAuthority("read")
//				.antMatchers("/content/create").hasAuthority("write")
//				.antMatchers("/content/update").hasAuthority("update")
//				.antMatchers("/content/delete/*").hasAuthority("delete")
		http.authorizeRequests()
				// Our public endpoints
				.antMatchers("/api/public/**").permitAll()
				.antMatchers(HttpMethod.GET, "/user", "user/info/*").permitAll()
				.antMatchers(HttpMethod.POST, "/user").hasAuthority("write")
				.antMatchers(HttpMethod.PATCH, "/user/*/status").hasAuthority("update")
				.antMatchers(HttpMethod.DELETE, "/user").hasAuthority("delete")
				// Our private endpoints
				.anyRequest().authenticated();

		// Add JWT token filter
		http.addFilterBefore(
				jwtFilter,
				UsernamePasswordAuthenticationFilter.class
		);
	}

	// Used by spring security if CORS is enabled.
	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source =
				new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}
}
