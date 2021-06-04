package com.iranoan.yugioh.service.csv;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.iranoan.yugioh.service.csv.dto.CardCsvDTO;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.MappingStrategy;

@Service
public class CsvReaderService {

	@Value("${yugioh.csv.filename}")
	private String file;

	public List<CardCsvDTO> readCsvFile() throws FileNotFoundException {
		return readCsvFile(file);
	}

	public List<CardCsvDTO> readCsvFile(String file) throws FileNotFoundException {
		FileReader filereader = new FileReader(file);
		CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
		CSVReader csvReader = new CSVReaderBuilder(filereader).withCSVParser(parser).build();
		MappingStrategy<CardCsvDTO> mappingStrategy = new ColumnPositionMappingStrategy<>();

		CsvToBean<CardCsvDTO> csvToBean = new CsvToBean<>();
		csvToBean.setCsvReader(csvReader);
		csvToBean.setMappingStrategy(mappingStrategy);

		return csvToBean.parse();
	}
}
