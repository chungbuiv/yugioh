package com.iranoan.yugioh.service.csv;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.iranoan.yugioh.service.csv.dto.CardCsvDTO;
import com.iranoan.yugioh.service.csv.dto.CardRarityStoreDTO;
import com.iranoan.yugioh.service.dto.CardDTO;
import com.iranoan.yugioh.service.dto.CardDetailDTO;
import com.iranoan.yugioh.service.dto.RarityDTO;
import com.iranoan.yugioh.service.dto.StoreDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CsvReaderService {

	@Value("${yugioh.csv.filename}")
	private String file;

	public List<CardDetailDTO> getCardDetailDTO() {
		Map<CardDTO, List<CardRarityStoreDTO>> collect = readCsvFile().stream()
				.map(cardCsvDTO -> convertToCardRarityStoreDTO(cardCsvDTO))
				.collect(groupingBy(CardRarityStoreDTO::getCardDTO));

		List<CardDetailDTO> cardDetailDTOs = new ArrayList<>();
		for (Map.Entry<CardDTO, List<CardRarityStoreDTO>> entry : collect.entrySet()) {
			CardDetailDTO cardDetailDTO = new CardDetailDTO();
			cardDetailDTO.setCardInfo(entry.getKey());
			cardDetailDTO.setRarities(getRarityDTOs(entry.getValue()));
			cardDetailDTOs.add(cardDetailDTO);
		}
		log.debug("Lis of card detail reading from CSV file: {}", cardDetailDTOs);

		return cardDetailDTOs;
	}

	private List<CardCsvDTO> readCsvFile() {
		try {
			return CsvReaderUtil.readCsvFile(file);
		} catch (Exception e) {
			log.error("Error in reading CSV file", e);
			throw new RuntimeException(e);
		}
	}

	private CardRarityStoreDTO convertToCardRarityStoreDTO(CardCsvDTO cardCsvDTO) {
		CardDTO cardDTO = new CardDTO();
		cardDTO.setCardName(cardCsvDTO.getCardName());
		cardDTO.setCardNameEnglish(cardCsvDTO.getCardNameEnglish());
		cardDTO.setCardProperty(cardCsvDTO.getCardProperty());
		cardDTO.setCardRank(cardCsvDTO.getCardRank());
		cardDTO.setCardType(cardCsvDTO.getCardType());
		cardDTO.setCardAttack(cardCsvDTO.getCardAttack());
		cardDTO.setCardDefence(cardCsvDTO.getCardDefence());
		cardDTO.setCardCode(cardCsvDTO.getCardCode());

		RarityDTO rarityDTO = new RarityDTO();
		rarityDTO.setRarityCode(cardCsvDTO.getRarityCode());
		rarityDTO.setRarityName(cardCsvDTO.getRarityName());
		rarityDTO.setImageUrl(cardCsvDTO.getImageUrl());

		StoreDTO sellStoreDTO = new StoreDTO();
		sellStoreDTO.setStoreName(cardCsvDTO.getSellStoreName());
		sellStoreDTO.setStoreLink(cardCsvDTO.getSellStoreLink());
		sellStoreDTO.setPrice(cardCsvDTO.getSellCardPrice());
		sellStoreDTO.setVolume(cardCsvDTO.getSellCardVolume());
		sellStoreDTO.setQuality(cardCsvDTO.getSellQuality());

		StoreDTO buyStoreDTO = new StoreDTO();
		buyStoreDTO.setStoreName(cardCsvDTO.getBuyStoreName());
		buyStoreDTO.setStoreLink(cardCsvDTO.getBuyStoreLink());
		buyStoreDTO.setPrice(cardCsvDTO.getBuyCardPrice());
		buyStoreDTO.setVolume(cardCsvDTO.getBuyCardVolume());
		buyStoreDTO.setQuality(cardCsvDTO.getBuyQuality());

		CardRarityStoreDTO cardRarityDTO = new CardRarityStoreDTO();
		cardRarityDTO.setCardDTO(cardDTO);
		cardRarityDTO.setRarityDTO(rarityDTO);
		cardRarityDTO.setBuyStore(buyStoreDTO);
		cardRarityDTO.setSellStore(sellStoreDTO);

		return cardRarityDTO;
	}

	private List<RarityDTO> getRarityDTOs(List<CardRarityStoreDTO> cardRarityStoreDTOs) {
		if (!cardRarityStoreDTOs.isEmpty()
				&& Strings.isEmpty(cardRarityStoreDTOs.get(0).getRarityDTO().getRarityName())) {
			cardRarityStoreDTOs.remove(0); // Remove the first element because it is the parent card information
		}

		List<RarityDTO> rarityDTOs = new ArrayList<>();
		Map<RarityDTO, List<CardRarityStoreDTO>> rarityMap = cardRarityStoreDTOs.stream()
				.collect(groupingBy(CardRarityStoreDTO::getRarityDTO));

		for (Map.Entry<RarityDTO, List<CardRarityStoreDTO>> entry : rarityMap.entrySet()) {
			RarityDTO rarityDTO = new RarityDTO();
			rarityDTO.setRarityCode(entry.getKey().getRarityCode());
			rarityDTO.setRarityName(entry.getKey().getRarityName());
			rarityDTO.setImageUrl(entry.getKey().getImageUrl());
			rarityDTO.setBuyStores(
					entry.getValue().stream().map(CardRarityStoreDTO::getBuyStore).distinct().collect(toList()));
			rarityDTO.setSellStores(
					entry.getValue().stream().map(CardRarityStoreDTO::getSellStore).distinct().collect(toList()));
			rarityDTOs.add(rarityDTO);
		}

		return rarityDTOs;
	}
}
