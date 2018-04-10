package com.springsecurity.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@Configuration
@EnableWebSecurity //启用web安全性
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private DataSource dataSource;

	//配置存储用户
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//启用内存用户存储
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER").and()
		.withUser("admin").password("password").roles("USER","ADMIN");
		//等价
		/*auth.inMemoryAuthentication().withUser("user").password("password").authorities("ROLE_USER").and()
		.withUser("admin").password("password").authorities("ROLE_USER","ROLE_ADMIN");*/
	
		//启用数据库用户存储
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select username,password,true from Spitter where username=?")
		.authoritiesByUsernameQuery("select username,'ROLE_USER' from Spitter where username=?")
		.passwordEncoder(new StandardPasswordEncoder("53cr3t"));
		
		//base
		auth.ldapAuthentication().userSearchFilter("(uid={0})").groupSearchFilter("member={0}");
		//searchFilter
		auth.ldapAuthentication().userSearchBase("ou=people").userSearchFilter("(uid={0})")
		.groupSearchBase("ou=groups").groupSearchFilter("member={0}");
		//comparePwd
	    //密码比对进行认证
		auth.ldapAuthentication().userSearchBase("ou=people").userSearchFilter("(uid={0})")
		.groupSearchBase("ou=groups").groupSearchFilter("member={0}")
		.passwordCompare().passwordEncoder(new Md5PasswordEncoder()).passwordAttribute("passcode");
	
		//指定远程LDAP服务器
		auth.ldapAuthentication().userSearchFilter("(uid={0})").groupSearchFilter("member={0}")
		.contextSource().url("ldap://habuma.com:389/dc=habuma,dc=com");
	}
}
