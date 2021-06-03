package com.iranoan.yugioh.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.iranoan.yugioh.repository.CardRepository;
import com.iranoan.yugioh.repository.RarityRepository;
import com.iranoan.yugioh.repository.StoreRepository;
import com.iranoan.yugioh.service.dto.CardBasicDTO;
import com.iranoan.yugioh.service.dto.CardDTO;
import com.iranoan.yugioh.service.dto.InitCardDTO;
import com.iranoan.yugioh.service.dto.SearchedCardDTO;
import com.iranoan.yugioh.service.dto.SearchedRarityDTO;
import com.iranoan.yugioh.service.dto.StoreDTO;
import com.iranoan.yugioh.service.dto.StoreListDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CardService {

	private final CardRepository cardRepository;
	private final StoreRepository storeRepository;
	private final RarityRepository rarityRepository;

	public SearchedCardDTO searchCards(String keyword) {
		SearchedCardDTO searchedCardDTO = new SearchedCardDTO();
		List<CardDTO> cardDTOs;
		if (keyword == null) {
			cardDTOs = cardRepository.getAllCardDTOs();
		} else {
			cardDTOs = cardRepository.searchCardByKeyword(keyword);
		}
		searchedCardDTO.setSearchedCards(cardDTOs);
		return searchedCardDTO;
	}

	public InitCardDTO initCards() {
		InitCardDTO initCardDTO = new InitCardDTO();
		List<CardDTO> cardDTOs = cardRepository.getLimitedCardDTOs(10);
		initCardDTO.setInitCards(cardDTOs);
		return initCardDTO;
	}

	public StoreListDTO purchaseProducts(String rarityId) {
		StoreListDTO storeListDTO = new StoreListDTO();
		storeListDTO.setStoreType(0);
		List<StoreDTO> allStores = storeRepository.findByRarityId(rarityId);
		storeListDTO.setListStoreInfo(allStores);
		return storeListDTO;
	}

	public StoreListDTO saleProducts(String rarityId) {
		StoreListDTO storeListDTO = new StoreListDTO();
		storeListDTO.setStoreType(1);
		List<StoreDTO> allStores = storeRepository.findByRarityId(rarityId);
		storeListDTO.setListStoreInfo(allStores);
		return storeListDTO;
	}

	public SearchedRarityDTO searchRarities(String cardId) {
		SearchedRarityDTO searchedRarityDTO = new SearchedRarityDTO();
		CardBasicDTO cardBasicDTO = new CardBasicDTO();
		CardDTO cardDTO = cardRepository.findByCardId(cardId).orElseThrow();
		cardBasicDTO.setCardId(cardDTO.getCardId());
		cardBasicDTO.setCardName(cardDTO.getCardName());
		searchedRarityDTO.setCardBasicInfo(cardBasicDTO);
		searchedRarityDTO.setSearchedRarities(rarityRepository.findByCardId(cardId));
		return searchedRarityDTO;
	}

}
