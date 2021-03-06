package com.iranoan.yugioh.service.dto;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CardDTO extends CardBasicDTO {
	private String cardProperty;
	private Integer cardRank;
	private String cardType;
	private Integer cardAttack;
	private Integer cardDefence;
	private Integer minValue;
	private Integer maxValue;
	private String imageUrl;
	private List<ValueDTO> values;
}
