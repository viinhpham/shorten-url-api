package org.vinh.shortenUrl.domain.service.impl;

import org.vinh.shortenUrl.domain.UrlDomain;
import org.vinh.shortenUrl.dto.UrlRequest;
import org.vinh.shortenUrl.domain.service.UrlDomainService;

import java.net.MalformedURLException;
import java.net.URL;

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
			URL url = new URL(urlRequest.getUrl());

			for (int i = 0; i < 6; i++) {
				encodedUrl.append(AlPHABET.charAt((int) (Math.random() * AlPHABET.length())));
			}
			
			 urlDomain = UrlDomain.builder()
					.shortenedUrl(url.getProtocol() + "://" + url.getHost() + "/" + encodedUrl) // use constant instead
					.originUrl(urlRequest.getUrl()).build();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return urlDomain;
	}
}
