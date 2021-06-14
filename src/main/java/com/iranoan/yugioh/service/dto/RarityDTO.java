package com.iranoan.yugioh.service.dto;

import java.util.List;

import lombok.Data;

@Data
public class RarityDTO {
	private String rarityName;
	private String rarityCode;
	private String otherFactor;
	private String imageUrl;
	private List<StoreDTO> buyStores;
	private List<StoreDTO> sellStores;
}
