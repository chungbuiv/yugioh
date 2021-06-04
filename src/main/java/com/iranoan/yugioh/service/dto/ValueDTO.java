package com.iranoan.yugioh.service.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValueDTO {
	private LocalDateTime time;
	private int value;
}
