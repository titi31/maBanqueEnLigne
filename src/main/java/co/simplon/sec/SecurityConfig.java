package co.simplon.sec;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder ;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	@Autowired
	private DataSource datasource; 
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		/*auth.inMemoryAuthentication().withUser("user").password("{noop}tortue").roles("USER");
		auth.inMemoryAuthentication().withUser("mohamed").password("{noop}elbabili").roles("ADMIN","USER");*/
		auth.jdbcAuthentication()
		.dataSource(datasource)
		.usersByUsernameQuery("select username as principal,passwordname as credentials,active from T_Users where username=?")
		.authoritiesByUsernameQuery("select username as principal,role as role from users_roles where username=?")
		.rolePrefix("ROLE_")
		.passwordEncoder(new BCryptPasswordEncoder());
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.formLogin();//.loginPage("/login");
		http.authorizeRequests().antMatchers("/operations","/consulterCompte").hasRole("USER");
		http.authorizeRequests().antMatchers("/saveOperation").hasRole("ADMIN");
		http.exceptionHandling().accessDeniedPage("/403");
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		   PasswordEncoder encoder = new BCryptPasswordEncoder();
		    return encoder;
	}
	

}
