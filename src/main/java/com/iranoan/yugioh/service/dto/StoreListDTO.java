package com.iranoan.yugioh.service.dto;

import java.util.List;

import lombok.Data;

@Data
public class StoreListDTO {
	private Integer storeType;
	private List<StoreDTO> listStoreInfo;
}
