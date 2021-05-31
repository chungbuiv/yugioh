package com.iranoan.yugioh.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.iranoan.yugioh.service.dto.CardDTO;

@Service
public class CardService {

	public List<CardDTO> searchCards() {
		List<CardDTO> cardDTOs = new ArrayList<>();
		CardDTO cardDTO = new CardDTO();
		cardDTO.setCardId("Test");
		cardDTOs.add(cardDTO);
		return cardDTOs;
	}
}
