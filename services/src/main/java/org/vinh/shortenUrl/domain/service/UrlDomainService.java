package org.vinh.shortenUrl.domain.service;

import org.vinh.shortenUrl.domain.UrlDomain;
import org.vinh.shortenUrl.dto.UrlRequest;

/**
 * Author : Vinh Pham.
 * Date: 7/12/21.
 * Time : 10:30 PM.
 */
public interface UrlDomainService {
	UrlDomain shortenUrl(UrlRequest url);
}
