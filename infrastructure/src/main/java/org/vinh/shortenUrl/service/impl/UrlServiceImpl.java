package org.vinh.shortenUrl.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vinh.shortenUrl.converter.UrlConverter;
import org.vinh.shortenUrl.domain.UrlDomain;
import org.vinh.shortenUrl.domain.service.UrlDomainService;
import org.vinh.shortenUrl.dto.UrlRequest;
import org.vinh.shortenUrl.entity.UrlEntity;
import org.vinh.shortenUrl.repository.UrlRepository;
import org.vinh.shortenUrl.service.UrlService;

import java.util.List;

/**
 * Author : Vinh Pham.
 * Date: 7/15/21.
 * Time : 8:58 AM.
 */
@Service
@Transactional
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
		//Need to improve performance for this because it's full scan table.
		UrlEntity urlEntity = urlRepository.findByOriginUrl(urlDto.getUrl());
		UrlDomain  urlDomain = null;
		if (urlEntity != null) {
			urlDomain = urlConverter.toDomain(urlEntity);

		} else {
			urlDomain = urlDomainService.shortenUrl(urlDto);

			urlRepository.save(urlConverter.toEntity(urlDomain));
		}
		//Will use appropriate response dto later
		urlDomain.setOriginUrl(null);

		return urlDomain;
	}

	@Override
	public UrlDomain getOriginUrl(UrlRequest urlDto) {
		return UrlDomain.builder().originUrl(urlRepository.findByShortenedUrlOnly(urlDto.getUrl())).build();
	}

	@Override
	public List<UrlDomain> getAll() {
		return urlConverter.toDomains(urlRepository.findAll());
	}
}
