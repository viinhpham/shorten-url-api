package org.vinh.shortenUrl.converter;

import org.mapstruct.Mapper;
import org.vinh.shortenUrl.domain.UrlDomain;
import org.vinh.shortenUrl.entity.UrlEntity;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Author : Vinh Pham.
 * Date: 7/16/21.
 * Time : 12:13 AM.
 */
@Mapper(componentModel = "spring")
public interface UrlConverter{

	UrlEntity toEntity(UrlDomain urlDomain);

	UrlDomain toDomain(UrlEntity urlEntity);

	default List<UrlDomain> toDomains(List<UrlEntity> urlEntities) {
		return urlEntities.stream().map(this::toDomain).collect(Collectors.toList());
	}
}
