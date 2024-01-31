package org.vinh.shortenUrl.domain.service.impl;

import io.github.pixee.security.HostValidator;
import io.github.pixee.security.Urls;
import org.vinh.shortenUrl.domain.UrlDomain;
import org.vinh.shortenUrl.dto.UrlRequest;
import org.vinh.shortenUrl.domain.service.UrlDomainService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.IntStream;

/**
 * Author : Vinh Pham.
 * Date: 7/14/21.
 * Time : 11:02 PM.
 */
public class UrlDomainServiceImpl implements UrlDomainService {

	private static final String AlPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	@Override
	public UrlDomain shortenUrl(UrlRequest urlRequest) {
		UrlDomain urlDomain = null;
		try {
			StringBuilder encodedUrl = new StringBuilder();
			URL url = Urls.create(urlRequest.getUrl(), Urls.HTTP_PROTOCOLS, HostValidator.DENY_COMMON_INFRASTRUCTURE_TARGETS);

			IntStream.range(0, 6).forEach((x) -> encodedUrl.append(AlPHABET.charAt((int) (Math.random() * AlPHABET.length()))));

			 urlDomain = UrlDomain.builder()
					.shortenedUrl(url.getProtocol() + "://" + url.getHost() + "/" + encodedUrl) // use constant instead
					.originUrl(urlRequest.getUrl()).build();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return urlDomain;
	}
}
