package com.iranoan.yugioh.service.util;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import com.iranoan.yugioh.service.dto.CardDTO;
import com.iranoan.yugioh.service.dto.CardDetailDTO;
import com.iranoan.yugioh.service.dto.NewsDTO;
import com.iranoan.yugioh.service.dto.RarityDTO;
import com.iranoan.yugioh.service.dto.StoreDTO;
import com.iranoan.yugioh.service.dto.ValueDTO;

public class MockDataUtil {

	private static final int NUMBER_CARD = 100;
	private static final int NUMBER_NEWS = 10;
	private static final int NUMBER_STORE = 5;
	private static final int NUMBER_RARITY = 5;

	public static List<CardDTO> generateCards() {
		List<CardDTO> cardDTOs = new ArrayList<>();
		for (int i = 0; i < NUMBER_CARD; i++) {
			CardDTO cardDTO = new CardDTO();
			cardDTO.setId(Long.valueOf(i));
			cardDTO.setCardCode("PAC1-JP" + i);
			cardDTO.setCardName("深淵の青眼龍" + i);
			cardDTO.setCardNameEnglish("Blue-Eyes Abyss Dragon" + i);
			cardDTO.setCardProperty("光属性");
			cardDTO.setCardRank(i + 1);
			cardDTO.setCardType("ドラゴン族");
			cardDTO.setCardAttack(1000 + i);
			cardDTO.setCardDefence(1000 - i);
			cardDTO.setImageUrl("images/card" + i);
			List<ValueDTO> valueDTOs = createValueDTOs(24);
			Integer minValue = valueDTOs.stream() //
					.map(ValueDTO::getValue) //
					.min(Comparator.comparing(Integer::intValue)) //
					.get();
			Integer maxValue = valueDTOs.stream() //
					.map(ValueDTO::getValue) //
					.max(Comparator.comparing(Integer::intValue)) //
					.get();
			cardDTO.setMinValue(minValue);
			cardDTO.setMaxValue(maxValue);
			cardDTO.setValues(valueDTOs);
			cardDTOs.add(cardDTO);
		}
		return cardDTOs;
	}

	private static List<ValueDTO> createValueDTOs(int numberElements) {
		List<ValueDTO> valueDTOs = new ArrayList<>();
		LocalDateTime currentDateTime = LocalDateTime.now().truncatedTo(ChronoUnit.HOURS);
		LocalDateTime beginDateTime = currentDateTime.minusHours(numberElements);
		for (int i = 0; i < numberElements; i++) {
			ValueDTO valueDTO = new ValueDTO(beginDateTime.plusHours(i), getRandomPrice());
			valueDTOs.add(valueDTO);
		}
		return valueDTOs;
	}

	private static int getRandomPrice() {
		int randomInt = ThreadLocalRandom.current().nextInt(1, 51);
		return 100 * randomInt;
	}

	public static List<NewsDTO> generateNews() {
		List<NewsDTO> newsDTOs = new ArrayList<>();
		for (int i = 0; i < NUMBER_NEWS; i++) {
			NewsDTO newsDTO = new NewsDTO();
			newsDTO.setContain("コナミフレンドリーショップ限定！デュエリストカードプロテクターセット「千年パズル／KC」発売決定！" + i);
			newsDTO.setImgUrl("images/img" + i);
			newsDTO.setLink("https://www.google.com/");
			newsDTOs.add(newsDTO);
		}
		return newsDTOs;
	}

	public static List<CardDetailDTO> generateCardDetails() {
		List<CardDTO> cardDTOs = generateCards();
		return cardDTOs.stream().map(card -> {
			CardDetailDTO cardDetailDTO = new CardDetailDTO();
			cardDetailDTO.setCardInfo(card);
			cardDetailDTO.setRarities(generateRarities());
			return cardDetailDTO;
		}).collect(Collectors.toList());
	}

	public static List<RarityDTO> generateRarities() {
		List<RarityDTO> rarityDTOs = new ArrayList<>();
		for (int i = 0; i < NUMBER_RARITY; i++) {
			RarityDTO rarityDTO = new RarityDTO();
			rarityDTO.setRarityCode("TDGS-JP" + i);
			rarityDTO.setRarityName("ウルトラ" + i);
			rarityDTO.setImageUrl("https://www.google.com/");
			rarityDTO.setBuyStores(generateStores());
			rarityDTO.setSellStores(generateStores());
			rarityDTOs.add(rarityDTO);
		}
		return rarityDTOs;
	}

	private static List<StoreDTO> generateStores() {
		List<StoreDTO> storeDTOs = new ArrayList<>();
		for (int i = 0; i < NUMBER_STORE; i++) {
			StoreDTO storeDTO = new StoreDTO();
			storeDTO.setStoreName("Store ABC");
			storeDTO.setStoreLink("https://www.google.com/");
			storeDTO.setQuality("Good");
			storeDTO.setVolume(10);
			storeDTO.setPrice(1000);
			storeDTOs.add(storeDTO);
		}
		return storeDTOs;
	}
}