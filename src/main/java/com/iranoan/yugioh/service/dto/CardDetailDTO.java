package com.iranoan.yugioh.service.dto;

import java.util.List;

import lombok.Data;

@Data
public class CardDetailDTO {
	private CardDTO cardInfo;
	List<RarityDTO> rarities;
}
