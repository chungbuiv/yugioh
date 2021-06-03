package com.iranoan.yugioh.repository;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iranoan.yugioh.service.dto.RarityDTO;
import com.iranoan.yugioh.service.util.MockDataUtil;

@Repository
public class RarityRepository {
	private static List<RarityDTO> rarityDTOs;

	static {
		rarityDTOs = MockDataUtil.generateRarities();
	}

	public List<RarityDTO> getAllRarities() {
		return rarityDTOs;
	}

	public List<RarityDTO> getLimitedRarities(int numberRarities) {
		return rarityDTOs.stream().limit(numberRarities).collect(toList());
	}

	public List<RarityDTO> findByCardId(String cardId) {
		return getLimitedRarities(10);
	}
}
