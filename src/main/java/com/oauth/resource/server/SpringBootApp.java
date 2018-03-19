package com.oauth.resource.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.oauth.resource.server.config.AppConfig;

import org.springframework.context.annotation.ComponentScan.Filter;


/**
*
* @author hassan.khani
* @version 1.1.20170429
* @change 
* @target
* 
*/


@SpringBootApplication(scanBasePackages={"com.oauth.resource"})
@Import({ AppConfig.class})
public class SpringBootApp extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootApp.class);
		
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootApp.class, args);
	}

}