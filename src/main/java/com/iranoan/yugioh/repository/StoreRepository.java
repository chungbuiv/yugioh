package com.iranoan.yugioh.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iranoan.yugioh.service.dto.StoreDTO;
import com.iranoan.yugioh.service.util.MockDataUtil;

@Repository
public class StoreRepository {
	private static List<StoreDTO> storeDTOs;

	static {
		storeDTOs = MockDataUtil.generateStores();
	}

	public List<StoreDTO> getAllStores() {
		return storeDTOs;
	}

	public List<StoreDTO> findByRarityId(String rarityCode) {
		return storeDTOs;
	}

}
