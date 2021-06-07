package com.iranoan.yugioh.web.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iranoan.yugioh.service.CardService;
import com.iranoan.yugioh.service.constant.PriceType;
import com.iranoan.yugioh.service.constant.StatisticPeriod;
import com.iranoan.yugioh.service.dto.CardDetailDTO;
import com.iranoan.yugioh.service.dto.CardInitDTO;
import com.iranoan.yugioh.service.dto.SearchedCardDTO;
import com.iranoan.yugioh.service.dto.ValueDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/rest/card")
@RequiredArgsConstructor
public class CardResource {

	private final CardService cardService;

	@GetMapping("/search")
	public SearchedCardDTO searchCards(@RequestParam(value = "keyword", required = false) String keyword) {
		return cardService.searchCards(keyword);
	}

	@GetMapping("/init")
	public CardInitDTO initCards() {
		return cardService.initCards();
	}

	@GetMapping("/detail/{id}")
	public CardDetailDTO getCardDetail(@PathVariable("id") Long cardId) {
		return cardService.getCardDetail(cardId).orElse(null);
	}

	@GetMapping("/detail/{id}/{statisticPeriod}/{priceType}")
	public List<ValueDTO> getValues(@PathVariable("id") Long cardId, //
			@PathVariable("statisticPeriod") StatisticPeriod statisticPeriod, //
			@PathVariable("priceType") PriceType priceType) {
		return cardService.getValues(cardId, statisticPeriod, priceType);
	}

}
