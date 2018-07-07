package com.intellizest.security.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;


	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

//		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
//		auth.inMemoryAuthentication().withUser("consumer").password("password").roles("CONSUMER");
//		auth.inMemoryAuthentication().withUser("provider").password("password").roles("PROVIDER");
//		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
		
		auth.userDetailsService(userDetailsService);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(new String[]{"/resources/**"});
	}

	@Override
    protected void configure( HttpSecurity http ) throws Exception
    {
//        http
// 
//           
//            .requiresChannel()
//                .anyRequest().requiresSecure()
//                .and()
// 
//          
//            // The session management is used to ensure the user only has one session. This isn't
//            // compulsory but can add some extra security to your application.
//            .sessionManagement()
//                .invalidSessionUrl( "/login?time=1" )
//                .maximumSessions( 1 );
//               // .and()
// 
		
		http
			.exceptionHandling()
				.accessDeniedPage( "/access-denied" ).and() // this is the page users will be redirected to when they try to access protected areas.
		  	.authorizeRequests()
		  		.antMatchers( "/", "/login/**", "/logout/**", "/services/**", "/register/**" ).permitAll().and() // permits all for home page and services page
		  	.authorizeRequests()
		  		.antMatchers( "/admin/**" ).hasRole( "ADMIN" )
		  		.antMatchers( "/providers/**" ).hasRole( "PROVIDER" )
		  		.antMatchers( "/consumers/**" ).hasRole( "CONSUMER" )
		  		.anyRequest().authenticated().and()
		  	.formLogin()
		  		.loginPage( "/login" )
		  		.loginProcessingUrl( "/login" )
		  		.defaultSuccessUrl( "/" )
		  		.failureUrl( "/login?err=1" )
		  		.usernameParameter( "username" )
		  		.passwordParameter( "password" )
		  		.permitAll()
		  		.and()
		  	.logout()
			  	.logoutRequestMatcher( new AntPathRequestMatcher( "/logout" ) )
			  	.logoutSuccessUrl( "/login?out=1" )
			  	.deleteCookies( "JSESSIONID" )
	          	.invalidateHttpSession( true )
		  		.permitAll().and()
		  	.httpBasic().and() // TO use browser HTTP basic login pop up. Comment formLogin() to bring this to picture.
		  	.csrf().disable();
    }
 

	@Bean
	public static PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
