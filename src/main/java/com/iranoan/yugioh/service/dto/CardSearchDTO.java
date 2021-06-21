package com.iranoan.yugioh.service.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CardSearchDTO extends CardBasicDTO {
	private String imageUrl;
}
