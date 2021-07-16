package org.vinh.shortenUrl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vinh.shortenUrl.domain.UrlDomain;
import org.vinh.shortenUrl.dto.UrlRequest;
import org.vinh.shortenUrl.service.UrlService;

import java.util.List;

/**
 * Author : Vinh Pham.
 * Date: 7/12/21.
 * Time : 9:52 PM.
 */
@RestController
@RequestMapping("/urls")
public class ShortenUrlController {
	private final UrlService urlService;

	public ShortenUrlController(UrlService urlService) {
		this.urlService = urlService;
	}

	@PostMapping()
	public UrlDomain shortenUrl(@RequestBody UrlRequest urlDto){
		//TODO Validation and Error handling
		return urlService.shortenUrl(urlDto);
	}
	@PostMapping("/navigate")
	public UrlDomain navigateTo(@RequestBody UrlRequest urlDto){
		//TODO Validation and Error handling
		return urlService.getOriginUrl(urlDto);
	}
	@GetMapping
	public List<UrlDomain> getAllUrl(){
		return urlService.getAll();
	}

}
