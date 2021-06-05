package com.iranoan.yugioh.service.csv.dto;

import com.opencsv.bean.CsvBindByPosition;

import lombok.Data;

@Data
public class RarityCsvDTO {

	@CsvBindByPosition(position = 0)
	private String cardCode;

	@CsvBindByPosition(position = 1)
	private String rarityCode;

	@CsvBindByPosition(position = 2)
	private String rarityName;

	@CsvBindByPosition(position = 3)
	private String imageUrl;
}
