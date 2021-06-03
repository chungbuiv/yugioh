package com.iranoan.yugioh.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CardBasicDTO {
	private String cardName;

	@JsonProperty("cardID")
	private String cardId;
}
