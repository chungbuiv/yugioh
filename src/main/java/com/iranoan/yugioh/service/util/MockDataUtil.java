package com.iranoan.yugioh.service.util;

import static java.util.stream.Collectors.toList;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

import com.iranoan.yugioh.service.csv.CsvReaderService;
import com.iranoan.yugioh.service.dto.CardDTO;
import com.iranoan.yugioh.service.dto.CardDetailDTO;
import com.iranoan.yugioh.service.dto.NewsDTO;
import com.iranoan.yugioh.service.dto.ValueDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MockDataUtil {

	private static final int NUMBER_NEWS = 10;
	private final CsvReaderService csvReaderService;

	public static List<NewsDTO> generateNews() {
		List<NewsDTO> newsDTOs = new ArrayList<>();
		for (int i = 0; i < NUMBER_NEWS; i++) {
			NewsDTO newsDTO = new NewsDTO();
			newsDTO.setContain("コナミフレンドリーショップ限定！デュエリストカードプロテクターセット「千年パズル／KC」発売決定！" + i);
			newsDTO.setImgUrl("images/img" + i);
			newsDTO.setLink("https://www.google.com/");
			newsDTOs.add(newsDTO);
		}
		return newsDTOs;
	}

	public List<CardDetailDTO> generateCardDetails() {
		List<CardDetailDTO> cardDetailDTOs = csvReaderService.getCardDetailDTO();
		long index = 0;
		for (CardDetailDTO cardDetailDTO : cardDetailDTOs) {
			CardDTO cardDTO = cardDetailDTO.getCardInfo();
			cardDTO.setId(++index);
			List<ValueDTO> valueDTOs = createValueDTOsByDay(7);
			Integer minValue = valueDTOs.stream() //
					.map(ValueDTO::getValue) //
					.min(Comparator.comparing(Integer::intValue)) //
					.get();
			Integer maxValue = valueDTOs.stream() //
					.map(ValueDTO::getValue) //
					.max(Comparator.comparing(Integer::intValue)) //
					.get();
			cardDTO.setMinValue(minValue);
			cardDTO.setMaxValue(maxValue);
			cardDTO.setValues(valueDTOs);
		}
		return cardDetailDTOs;
	}

	public List<CardDTO> generateInitCards() {
		List<CardDTO> cardDTOs = generateCardDetails().stream() //
				.map(CardDetailDTO::getCardInfo) //
				.collect(toList());
		for (CardDTO cardDTO : cardDTOs) {
			List<ValueDTO> valueDTOs = createValueDTOsByHour(24);
			Integer minValue = valueDTOs.stream() //
					.map(ValueDTO::getValue) //
					.min(Comparator.comparing(Integer::intValue)) //
					.get();
			Integer maxValue = valueDTOs.stream() //
					.map(ValueDTO::getValue) //
					.max(Comparator.comparing(Integer::intValue)) //
					.get();
			cardDTO.setMinValue(minValue);
			cardDTO.setMaxValue(maxValue);
			cardDTO.setValues(valueDTOs);
		}

		return cardDTOs;
	}

	private static List<ValueDTO> createValueDTOsByHour(int numberElements) {
		List<ValueDTO> valueDTOs = new ArrayList<>();
		LocalDateTime currentDateTime = LocalDateTime.now().truncatedTo(ChronoUnit.HOURS);
		LocalDateTime beginDateTime = currentDateTime.minusHours(numberElements);
		for (int i = 0; i < numberElements; i++) {
			ValueDTO valueDTO = new ValueDTO(beginDateTime.plusHours(i), getRandomValue());
			valueDTOs.add(valueDTO);
		}
		return valueDTOs;
	}

	private List<ValueDTO> createValueDTOsByDay(int numberElements) {
		List<ValueDTO> valueDTOs = new ArrayList<>();
		LocalDate currentDate = LocalDate.now();
		LocalDate beginDate = currentDate.minusDays(numberElements);
		for (int i = 0; i < numberElements; i++) {
			ValueDTO valueDTO = new ValueDTO(beginDate.plusDays(i).atStartOfDay(), getRandomValue());
			valueDTOs.add(valueDTO);
		}
		return valueDTOs;
	}

	private static int getRandomValue() {
		int randomInt = ThreadLocalRandom.current().nextInt(1, 51);
		return 100 * randomInt;
	}

}