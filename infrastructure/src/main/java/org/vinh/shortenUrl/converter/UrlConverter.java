package org.vinh.shortenUrl.converter;

import org.mapstruct.Mapper;
import org.vinh.shortenUrl.domain.UrlDomain;
import org.vinh.shortenUrl.entity.UrlEntity;

import java.time.LocalDateTime;

/**
 * Author : Vinh Pham.
 * Date: 7/16/21.
 * Time : 12:13 AM.
 */
@Mapper(componentModel = "spring")
public interface UrlConverter{

	default UrlEntity toEntity(UrlDomain urlDomain) {
		UrlEntity urlEntity = new UrlEntity();
		urlEntity.setOriginUrl(urlDomain.getOriginUrl());
		urlEntity.setCreatedDate(LocalDateTime.now());
		urlEntity.setId(urlDomain.getShortenedUrl());

		return urlEntity;
	}
}
