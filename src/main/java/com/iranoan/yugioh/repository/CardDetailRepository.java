package com.iranoan.yugioh.repository;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.iranoan.yugioh.service.dto.CardDetailDTO;
import com.iranoan.yugioh.service.util.MockDataUtil;

@Repository
public class CardDetailRepository {
	private static List<CardDetailDTO> cardDetailDTOs;

	static {
		cardDetailDTOs = MockDataUtil.generateCardDetails();
	}

	public List<CardDetailDTO> getAllCardDTOs() {
		return cardDetailDTOs;
	}

	public List<CardDetailDTO> getLimitedCardDTOs(int numberCards) {
		return cardDetailDTOs.stream().limit(numberCards).collect(toList());
	}

	public Optional<CardDetailDTO> findByCardId(Long cardId) {
		return cardDetailDTOs.stream()//
				.filter(cardDetail -> cardDetail.getCardInfo().getId().equals(cardId)) //
				.findFirst();
	}
}
