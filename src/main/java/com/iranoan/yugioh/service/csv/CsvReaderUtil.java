package com.iranoan.yugioh.service.csv;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.iranoan.yugioh.service.csv.dto.CardCsvDTO;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.bean.MappingStrategy;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class CsvReaderUtil {

	public static List<CardCsvDTO> readCsvFile(String file) throws CsvRequiredFieldEmptyException, IOException {
		FileReader filereader = new FileReader(file);
		CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
		CSVReader csvReader = new CSVReaderBuilder(filereader).withCSVParser(parser).build();
		MappingStrategy<CardCsvDTO> mappingStrategy = new HeaderColumnNameMappingStrategy<CardCsvDTO>();
		mappingStrategy.setType(CardCsvDTO.class);

		CsvToBean<CardCsvDTO> csvToBean = new CsvToBean<>();
		csvToBean.setCsvReader(csvReader);
		csvToBean.setMappingStrategy(mappingStrategy);

		return csvToBean.parse();
	}
}
