package org.vinh.shortenUrl.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vinh.shortenUrl.dto.UrlRequest;
import org.vinh.shortenUrl.service.UrlService;

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
	public ResponseEntity shortenUrl(@RequestBody UrlRequest urlDto){
		return ResponseEntity.ok(urlService.shortenUrl(urlDto));
	}
	@GetMapping
	public String navigateTo(){
		return "hello";
	}

}
