package com.iranoan.yugioh.service;

import org.springframework.stereotype.Service;

import com.iranoan.yugioh.repository.NewsRepository;
import com.iranoan.yugioh.service.dto.NewsListDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NewsService {

	private final NewsRepository newsRepository;

	public NewsListDTO getNews() {
		NewsListDTO newsListDTO = new NewsListDTO();
		newsListDTO.setListNewsInfo(newsRepository.getNews());
		return newsListDTO;
	}
}
