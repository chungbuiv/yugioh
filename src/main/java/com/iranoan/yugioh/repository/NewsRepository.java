package com.iranoan.yugioh.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iranoan.yugioh.service.dto.NewsDTO;
import com.iranoan.yugioh.service.util.MockDataUtil;

@Repository
public class NewsRepository {

	private static List<NewsDTO> newsDTOs;

	static {
		newsDTOs = MockDataUtil.generateNews();
	}

	public List<NewsDTO> getNews() {
		return newsDTOs;
	}
}
