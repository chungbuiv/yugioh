package com.iranoan.yugioh.service.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CardDTO {
	@JsonProperty("cardID")
	private String cardId;
	@JsonIgnore
	private String cardCode;

	private String cardName;
	private String cardNameEnglish;
	private String cardProperty;
	private Integer cardRank;
	private String cardType;
	private Integer cardAttack;
	private Integer cardDefence;
	private String textValues;
	private String url;
	private List<Integer> values;
}
