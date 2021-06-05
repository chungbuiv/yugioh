package com.iranoan.yugioh.service.csv.dto;

import com.iranoan.yugioh.service.dto.CardDTO;
import com.iranoan.yugioh.service.dto.RarityDTO;
import com.iranoan.yugioh.service.dto.StoreDTO;

import lombok.Data;

@Data
public class CardRarityStoreDTO {
	private CardDTO cardDTO;
	private RarityDTO rarityDTO;
	private StoreDTO sellStore;
	private StoreDTO buyStore;
}
