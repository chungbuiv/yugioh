package com.iranoan.yugioh.service.dto;

import lombok.Data;

@Data
public class StoreDTO {
	private Integer cardStatus;
	private Integer cardPrice;
	private String cardID;
	private String storeName;
	private String link;
}
