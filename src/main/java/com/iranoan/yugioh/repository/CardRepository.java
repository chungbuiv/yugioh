package com.iranoan.yugioh.repository;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.*;

import org.springframework.stereotype.Repository;

import com.iranoan.yugioh.service.dto.CardDTO;
import com.iranoan.yugioh.service.util.MockDataUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CardRepository {

	private final MockDataUtil mockDataUtil;

	public List<CardDTO> getAllCardDTOs() {
		return mockDataUtil.generateInitCards();
	}

	public List<CardDTO> getLimitedCardDTOs(int numberCards) {
		List<CardDTO> allCardDTOs = getAllCardDTOs();
		log.error("All cardDTOs: {}", allCardDTOs);
		return getAllCardDTOs().stream().limit(numberCards).collect(toList());
	}

	public Optional<CardDTO> findByCardId(Long cardId) {
		return getAllCardDTOs().stream().filter(card -> card.getId().equals(cardId)).findFirst();
	}

	public List<CardDTO> searchCardByKeyword(String keyword) {
		return getAllCardDTOs().stream().filter(card -> card.getCardName().contains(keyword) //
				|| card.getCardCode().contains(keyword) //
				|| card.getCardNameEnglish().contains(keyword)) //
				.collect(toList());
	}
}
