package org.vinh.shortenUrl.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Author : Vinh Pham.
 * Date: 7/12/21.
 * Time : 10:28 PM.
 */
@Builder
@Getter
public class UrlDomain {
	private String originUrl;
	private String shortenedUrl;
	private LocalDateTime createdDate;
}
