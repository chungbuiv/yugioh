package com.iranoan.yugioh.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.iranoan.yugioh.repository.CardDetailRepository;
import com.iranoan.yugioh.repository.CardRepository;
import com.iranoan.yugioh.service.dto.CardBasicDTO;
import com.iranoan.yugioh.service.dto.CardDTO;
import com.iranoan.yugioh.service.dto.CardDetailDTO;
import com.iranoan.yugioh.service.dto.CardInitDTO;
import com.iranoan.yugioh.service.dto.SearchedCardDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CardService {

	private final CardRepository cardRepository;
	private final CardDetailRepository cardDetailRepository;

	public SearchedCardDTO searchCards(String keyword) {
		SearchedCardDTO searchedCardDTO = new SearchedCardDTO();
		List<CardDTO> cardDTOs;
		if (keyword == null) {
			cardDTOs = cardRepository.getAllCardDTOs();
		} else {
			cardDTOs = cardRepository.searchCardByKeyword(keyword);
		}
		List<CardBasicDTO> cardBasicDTOs = cardDTOs.stream().map(card -> {
			CardBasicDTO cardBasic = new CardBasicDTO();
			cardBasic.setId(card.getId());
			cardBasic.setCardName(card.getCardName());
			return cardBasic;
		}).collect(Collectors.toList());
		searchedCardDTO.setSearchedCards(cardBasicDTOs);
		return searchedCardDTO;
	}

	public CardInitDTO initCards() {
		CardInitDTO initCardDTO = new CardInitDTO();
		List<CardDTO> cardDTOs = cardRepository.getLimitedCardDTOs(3);
		initCardDTO.setInitCards(cardDTOs);
		return initCardDTO;
	}

	public Optional<CardDetailDTO> getCardDetail(Long cardId) {
		return cardDetailRepository.findByCardId(cardId);
	}

}
