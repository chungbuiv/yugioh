package com.iranoan.yugioh.service.dto;

import java.util.List;

import lombok.Data;

@Data
public class SearchedRarityDTO {
	private CardBasicDTO cardBasicInfo;
	private List<RarityDTO> searchedRarities;
}
