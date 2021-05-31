package com.iranoan.yugioh.web.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iranoan.yugioh.service.CardService;
import com.iranoan.yugioh.service.dto.CardDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/rest")
@RequiredArgsConstructor
public class CardResource {

	private final CardService cardService;

	@GetMapping("/searchCards")
	public List<CardDTO> searchCards() {
		return cardService.searchCards();
	}
}
