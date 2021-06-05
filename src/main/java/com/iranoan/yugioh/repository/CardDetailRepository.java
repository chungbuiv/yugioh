package com.iranoan.yugioh.repository;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.iranoan.yugioh.service.dto.CardDetailDTO;
import com.iranoan.yugioh.service.util.MockDataUtil;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CardDetailRepository {

	private final MockDataUtil mockDataUtil;

	public List<CardDetailDTO> getAllCardDTOs() {
		return mockDataUtil.generateCardDetails();
	}

	public List<CardDetailDTO> getLimitedCardDTOs(int numberCards) {
		return getAllCardDTOs().stream().limit(numberCards).collect(toList());
	}

	public Optional<CardDetailDTO> findByCardId(Long cardId) {
		return getAllCardDTOs().stream()//
				.filter(cardDetail -> cardDetail.getCardInfo().getId().equals(cardId)) //
				.findFirst();
	}
}
