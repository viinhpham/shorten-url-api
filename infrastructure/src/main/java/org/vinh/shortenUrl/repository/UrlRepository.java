package org.vinh.shortenUrl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.vinh.shortenUrl.entity.UrlEntity;

/**
 * Author : Vinh Pham.
 * Date: 7/12/21.
 * Time : 10:36 PM.
 */
@Repository
public interface UrlRepository extends JpaRepository<UrlEntity, String> {
	UrlEntity findByOriginUrl(String url);

	@Query("select url.originUrl from UrlEntity url" )
	String findByShortenedUrlOnly(String url);

}
