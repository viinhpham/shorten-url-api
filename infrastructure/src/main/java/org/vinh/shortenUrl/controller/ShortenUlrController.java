package org.vinh.shortenUrl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author : Vinh Pham.
 * Date: 7/12/21.
 * Time : 9:52 PM.
 */
@RestController
@RequestMapping("/urls")
public class ShortenUlrController {
	@PostMapping()
	public void shortenUrl(){
	}
	@GetMapping
	public String helloWorld(){
		return "hello";
	}

}
