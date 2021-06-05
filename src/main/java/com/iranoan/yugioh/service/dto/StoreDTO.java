package com.iranoan.yugioh.service.dto;

import lombok.Data;

@Data
public class StoreDTO {
	private String storeName;
	private String storeLink;
	private Integer quality;
	private Integer price;
	private Integer volume;
}
