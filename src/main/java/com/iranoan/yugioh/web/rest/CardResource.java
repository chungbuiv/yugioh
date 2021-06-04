package com.iranoan.yugioh.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iranoan.yugioh.service.CardService;
import com.iranoan.yugioh.service.dto.CardDetailDTO;
import com.iranoan.yugioh.service.dto.CardInitDTO;
import com.iranoan.yugioh.service.dto.SearchedCardDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/rest")
@RequiredArgsConstructor
public class CardResource {

	private final CardService cardService;

	@GetMapping("/searchCards")
	public SearchedCardDTO searchCards(@RequestParam(value = "keyword", required = false) String keyword) {
		return cardService.searchCards(keyword);
	}

	@GetMapping("/initCards")
	public CardInitDTO initCards() {
		return cardService.initCards();
	}

	@GetMapping("/cardDetail/{id}")
	public CardDetailDTO getCardDetail(@PathVariable("id") Long cardId) {
		return cardService.getCardDetail(cardId).orElse(null);
	}

}
