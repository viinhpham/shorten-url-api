package org.vinh.shortenUrl.service.impl;

import org.springframework.stereotype.Service;
import org.vinh.shortenUrl.converter.UrlConverter;
import org.vinh.shortenUrl.domain.UrlDomain;
import org.vinh.shortenUrl.domain.service.UrlDomainService;
import org.vinh.shortenUrl.dto.UrlRequest;
import org.vinh.shortenUrl.repository.UrlRepository;
import org.vinh.shortenUrl.service.UrlService;

/**
 * Author : Vinh Pham.
 * Date: 7/15/21.
 * Time : 8:58 AM.
 */
@Service
public class UrlServiceImpl implements UrlService {
	private final UrlDomainService urlDomainService;
	private final UrlRepository urlRepository;
	private final UrlConverter urlConverter;

	public UrlServiceImpl(UrlDomainService urlDomainService, UrlRepository urlRepository, UrlConverter urlConverter) {
		this.urlDomainService = urlDomainService;
		this.urlRepository = urlRepository;
		this.urlConverter = urlConverter;
	}

	@Override
	public UrlDomain shortenUrl(UrlRequest urlDto) {
		UrlDomain  urlDomain = urlDomainService.shortenUrl(urlDto);

		urlRepository.save(urlConverter.toEntity(urlDomain));

		return urlDomain;
	}
}
