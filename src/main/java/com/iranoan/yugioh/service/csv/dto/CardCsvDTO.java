package com.iranoan.yugioh.service.csv.dto;

import com.opencsv.bean.CsvBindByName;

import lombok.Data;

@Data
public class CardCsvDTO {
	@CsvBindByName
	private String cardName;

	@CsvBindByName
	private String cardNameEnglish;

	@CsvBindByName
	private String cardProperty;

	@CsvBindByName
	private Integer cardRank;

	@CsvBindByName
	private String cardType;

	@CsvBindByName
	private Integer cardAttack;

	@CsvBindByName
	private Integer cardDefence;

	@CsvBindByName
	private String cardCode;

	@CsvBindByName
	private String rarityCode;

	@CsvBindByName
	private String imageUrl;

	@CsvBindByName
	private String rarityName;

	@CsvBindByName
	private String sellStoreName;

	@CsvBindByName
	private String sellStoreLink;

	@CsvBindByName
	private Integer sellCardPrice;

	@CsvBindByName
	private Integer sellCardVolume;

	@CsvBindByName
	private Integer sellQuality;

	@CsvBindByName
	private String buyStoreName;

	@CsvBindByName
	private String buyStoreLink;

	@CsvBindByName
	private Integer buyCardPrice;

	@CsvBindByName
	private Integer buyCardVolume;

	@CsvBindByName
	private Integer buyQuality;
}
