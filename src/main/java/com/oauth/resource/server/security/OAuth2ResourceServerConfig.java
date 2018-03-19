package com.oauth.resource.server.security;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter {

    
    @Override
    public void configure(final HttpSecurity http) throws Exception {        
		http
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
			.and()
			.authorizeRequests()
				.anyRequest().authenticated();		
    }

    @Override
    public void configure(final ResourceServerSecurityConfigurer config) {
    	DefaultTokenServices dts = tokenServices();
    	config.tokenServices(dts);
    }

    // JWT

    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        final DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(tokenStore());
        return tokenServices;
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
    	 JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
    	    Resource resource = new ClassPathResource("public.txt");
    	    String publicKey = null;
    	    try {
    	        publicKey = IOUtils.toString(resource.getInputStream());
    	    } catch (final IOException e) {
    	        throw new RuntimeException(e);
    	    }
    	    converter.setVerifierKey(publicKey);
        return converter;
    }

}
