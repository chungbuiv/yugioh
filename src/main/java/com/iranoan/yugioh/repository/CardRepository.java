package com.iranoan.yugioh.repository;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.*;

import org.springframework.stereotype.Repository;

import com.iranoan.yugioh.service.dto.CardDTO;
import com.iranoan.yugioh.service.util.MockDataUtil;

@Repository
public class CardRepository {
	private static List<CardDTO> cardDTOs;

	static {
		cardDTOs = MockDataUtil.generateCards();
	}

	public List<CardDTO> getAllCardDTOs() {
		return cardDTOs;
	}

	public List<CardDTO> getLimitedCardDTOs(int numberCards) {
		return cardDTOs.stream().limit(numberCards).collect(toList());
	}

	public Optional<CardDTO> findByCardId(Long cardId) {
		return cardDTOs.stream().filter(card -> card.getId().equals(cardId)).findFirst();
	}

	public List<CardDTO> searchCardByKeyword(String keyword) {
		return cardDTOs.stream()
				.filter(card -> card.getCardName().contains(keyword) || card.getCardCode().contains(keyword))
				.collect(toList());
	}
}
