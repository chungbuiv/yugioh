package com.iranoan.yugioh.service;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.iranoan.yugioh.repository.CardDetailRepository;
import com.iranoan.yugioh.repository.CardRepository;
import com.iranoan.yugioh.service.constant.PriceType;
import com.iranoan.yugioh.service.constant.StatisticPeriod;
import com.iranoan.yugioh.service.dto.CardBasicDTO;
import com.iranoan.yugioh.service.dto.CardDTO;
import com.iranoan.yugioh.service.dto.CardDetailDTO;
import com.iranoan.yugioh.service.dto.CardInitDTO;
import com.iranoan.yugioh.service.dto.SearchedCardDTO;
import com.iranoan.yugioh.service.dto.ValueDTO;
import com.iranoan.yugioh.service.util.MockDataUtil;

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

	public List<ValueDTO> getValues(Long cardId, StatisticPeriod statisticPeriod, PriceType priceType) {

		switch (statisticPeriod) {
		case ONE_MONTH:
			return MockDataUtil.createValueDTOs(30, ChronoUnit.DAYS);
		case THREE_MONTH:
			return MockDataUtil.createValueDTOs(3, ChronoUnit.MONTHS);
		case SIX_MONTH:
			return MockDataUtil.createValueDTOs(6, ChronoUnit.MONTHS);
		case ONE_YEAR:
			return MockDataUtil.createValueDTOs(12, ChronoUnit.MONTHS);
		case THREE_YEAR:
			return MockDataUtil.createValueDTOs(3, ChronoUnit.YEARS);
		case FIVE_YEAR:
			return MockDataUtil.createValueDTOs(5, ChronoUnit.YEARS);
		default:
			throw new UnsupportedOperationException("Statistic type is invalid!");
		}
	}
}
