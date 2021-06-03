package com.iranoan.yugioh.service.util;

import java.util.ArrayList;
import java.util.List;

import com.iranoan.yugioh.service.dto.CardDTO;
import com.iranoan.yugioh.service.dto.NewsDTO;
import com.iranoan.yugioh.service.dto.RarityDTO;
import com.iranoan.yugioh.service.dto.StoreDTO;

public class MockDataUtil {

	private static final int NUMBER_CARD = 100;
	private static final int NUMBER_NEWS = 100;
	private static final int NUMBER_STORE = 100;
	private static final int NUMBER_RARITY = 100;

	public static List<CardDTO> generateCards() {
		List<CardDTO> cardDTOs = new ArrayList<>();
		for (int i = 0; i < NUMBER_CARD; i++) {
			CardDTO cardDTO = new CardDTO();
			cardDTO.setCardId("post-" + i);
			cardDTO.setCardCode("PAC1-JP" + i);
			cardDTO.setCardName("深淵の青眼龍" + i);
			cardDTO.setCardNameEnglish("Blue-Eyes Abyss Dragon" + i);
			cardDTO.setCardProperty("光属性");
			cardDTO.setCardRank(i + 1);
			cardDTO.setCardType("ドラゴン族");
			cardDTO.setCardAttack(1000 + i);
			cardDTO.setCardDefence(1000 - i);
			cardDTO.setTextValues("¥10,230〜¥50,000");
			cardDTO.setUrl("images/card" + i);
			cardDTO.setValues(List.of(50, 20, 30, 50, 30, 80));
			cardDTOs.add(cardDTO);
		}
		return cardDTOs;
	}

	public static List<NewsDTO> generateNews() {
		List<NewsDTO> newsDTOs = new ArrayList<>();
		for (int i = 0; i < NUMBER_NEWS; i++) {
			NewsDTO newsDTO = new NewsDTO();
			newsDTO.setContain("コナミフレンドリーショップ限定！デュエリストカードプロテクターセット「千年パズル／KC」発売決定！" + i);
			newsDTO.setImgUrl("images/img" + i);
			newsDTO.setLink("");
			newsDTOs.add(newsDTO);
		}
		return newsDTOs;
	}

	public static List<StoreDTO> generateStores() {
		List<StoreDTO> storeDTOs = new ArrayList<>();
		for (int i = 0; i < NUMBER_STORE; i++) {
			StoreDTO storeDTO = new StoreDTO();
			storeDTO.setCardID("post-" + i);
			storeDTO.setCardPrice(10000 + i);
			storeDTO.setCardStatus(i % 3);
			storeDTO.setStoreName("遊戯王カード専門店NaRi");
			storeDTO.setLink("https://play.google.com/store?hl=en&tab=r8");
			storeDTOs.add(storeDTO);
		}
		return storeDTOs;
	}

	public static List<RarityDTO> generateRarities() {
		List<RarityDTO> rarityDTOs = new ArrayList<>();
		for (int i = 0; i < NUMBER_RARITY; i++) {
			RarityDTO rarityDTO = new RarityDTO();
			rarityDTO.setRarityCode("TDGS-JP" + i);
			rarityDTO.setRarityName("ウルトラ" + i);
			rarityDTOs.add(rarityDTO);
		}
		return rarityDTOs;
	}
}