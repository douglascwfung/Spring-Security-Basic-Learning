package net.icestone.springsecuritybasic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig  {


	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests( (auth)->auth
				.antMatchers("/myAccount","/myBalance","/myLoans","/myCards").authenticated()
				.antMatchers("/notices","/contact").permitAll()
				.anyRequest().authenticated()
		)
		.httpBasic(Customizer.withDefaults());
		return http.build();
	}

	
 /**
 * Approach 1 where we use withDefaultPasswordEncoder() method
 * while creating the user details
 */
//	@Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//
//    	UserDetails admin = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("12345")
//                .authorities("admin")
//                .build();
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("12345")
//                .authorities("read")
//                .build();
//        return new InMemoryUserDetailsManager(admin, user);
//    }

	
    /*
    * Approach 2 where we don't define password encoder
    * while creating the user details. Instead a separate
    * PasswordEncoder bean will be created.
    */
//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//
//        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
//        UserDetails admin = User.withUsername("admin").password("12345").authorities("admin").build();
//        UserDetails user = User.withUsername("user").password("12345").authorities("read").build();
//        userDetailsService.createUser(admin);
//        userDetailsService.createUser(user);
//        return userDetailsService;
//    }

	
//    @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource) {
//	  return new JdbcUserDetailsManager(dataSource);
//    }
	
    @Bean
    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
		return new BCryptPasswordEncoder();

    }
    
}