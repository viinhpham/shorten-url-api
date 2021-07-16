package org.vinh.shortenUrl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.vinh.shortenUrl.domain.service.UrlDomainService;
import org.vinh.shortenUrl.domain.service.impl.UrlDomainServiceImpl;

/**
 * Author : Vinh Pham.
 * Date: 7/14/21.
 * Time : 10:59 PM.
 */
@Configuration
public class BeanConfig {
	@Bean
	public UrlDomainService urlService(){
		return new UrlDomainServiceImpl();
	}
}
