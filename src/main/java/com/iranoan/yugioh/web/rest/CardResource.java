package com.iranoan.yugioh.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iranoan.yugioh.service.CardService;
import com.iranoan.yugioh.service.dto.InitCardDTO;
import com.iranoan.yugioh.service.dto.SearchedCardDTO;
import com.iranoan.yugioh.service.dto.SearchedRarityDTO;
import com.iranoan.yugioh.service.dto.StoreListDTO;

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
	public InitCardDTO initCards() {
		return cardService.initCards();
	}

	@GetMapping("/purchaseProducts")
	public StoreListDTO purchaseProducts(@RequestParam("rarityID") String rarityId) {
		return cardService.purchaseProducts(rarityId);
	}

	@GetMapping("/saleProducts")
	public StoreListDTO saleProducts(@RequestParam("rarityID") String rarityId) {
		return cardService.saleProducts(rarityId);
	}

	@GetMapping("/searchRarities")
	public SearchedRarityDTO searchRarities(@RequestParam("cardID") String cardId) {
		return cardService.searchRarities(cardId);
	}

}
