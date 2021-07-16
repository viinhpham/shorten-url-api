package org.vinh.shortenUrl.service;

import org.vinh.shortenUrl.domain.UrlDomain;
import org.vinh.shortenUrl.dto.UrlRequest;

import java.util.List;

/**
 * Author : Vinh Pham.
 * Date: 7/15/21.
 * Time : 8:58 AM.
 */
public interface UrlService {
	UrlDomain shortenUrl(UrlRequest urlDto);
	UrlDomain getOriginUrl(UrlRequest urlDto);
	List<UrlDomain> getAll();
}
