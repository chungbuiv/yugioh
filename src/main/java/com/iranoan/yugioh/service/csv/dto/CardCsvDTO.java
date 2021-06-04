package com.iranoan.yugioh.service.csv.dto;

import com.opencsv.bean.CsvBindByPosition;

import lombok.Data;

@Data
public class CardCsvDTO {
	@CsvBindByPosition(position = 0)
	private String cardName;

	@CsvBindByPosition(position = 1)
	private String cardNameEnglish;

	@CsvBindByPosition(position = 2)
	private String cardProperty;

	@CsvBindByPosition(position = 3)
	private Integer cardRank;

	@CsvBindByPosition(position = 4)
	private String cardType;

	@CsvBindByPosition(position = 5)
	private Integer cardAttack;

	@CsvBindByPosition(position = 6)
	private Integer cardDefence;

	@CsvBindByPosition(position = 7)
	private String cardCode;

	@CsvBindByPosition(position = 8)
	private String rarityCode;

	@CsvBindByPosition(position = 9)
	private String imageUrl;

	@CsvBindByPosition(position = 10)
	private String rarityName;

	@CsvBindByPosition(position = 11)
	private String sellStoreName;

	@CsvBindByPosition(position = 12)
	private String sellStoreLink;

	@CsvBindByPosition(position = 13)
	private Integer sellCardPrice;

	@CsvBindByPosition(position = 14)
	private Integer sellCardVolume;

	@CsvBindByPosition(position = 15)
	private Integer sellQuality;

	@CsvBindByPosition(position = 16)
	private String buyStoreName;

	@CsvBindByPosition(position = 17)
	private String buyStoreLink;

	@CsvBindByPosition(position = 18)
	private Integer buyCardPrice;

	@CsvBindByPosition(position = 19)
	private Integer buyCardVolume;

	@CsvBindByPosition(position = 20)
	private Integer buyQuality;
}
