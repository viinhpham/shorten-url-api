package org.vinh.shortenUrl.domain.service.impl;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.vinh.shortenUrl.domain.UrlDomain;
import org.vinh.shortenUrl.dto.UrlRequest;

/**
 * Author : Vinh Pham.
 * Date: 7/15/21.
 * Time : 2:15 PM.
 */
@ExtendWith(MockitoExtension.class)
class UrlDomainServiceImplTest {
	@InjectMocks
	private UrlDomainServiceImpl urlDomainService;

	@Test
	public void testUrlShortened() {
		UrlRequest request = new UrlRequest();
		request.setUrl("https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/cache/annotation/EnableCaching.html");
		UrlDomain result = urlDomainService.shortenUrl(request);
		Assertions.assertNotNull(result.getShortenedUrl());
		Assertions.assertEquals(6, result.getShortenedUrl().split("/")[3].length());
	}
}