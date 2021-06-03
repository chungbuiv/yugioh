package com.iranoan.yugioh.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iranoan.yugioh.service.NewsService;
import com.iranoan.yugioh.service.dto.NewsListDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/rest/news")
@RequiredArgsConstructor
public class NewsResource {

	private final NewsService newsService;

	@GetMapping
	public NewsListDTO getNews() {
		return newsService.getNews();
	}
}
