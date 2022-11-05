package org.example.helpers

import com.opencsv.CSVParser
import com.opencsv.CSVParserBuilder
import com.opencsv.CSVReader
import com.opencsv.CSVReaderBuilder
import com.opencsv.bean.CsvToBean
import com.opencsv.bean.CsvToBeanBuilder
import com.opencsv.bean.HeaderColumnNameMappingStrategy
import groovy.transform.CompileStatic

import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path

@CompileStatic
class CsvLoader<T> {

	char separator = ';'
	Class<T> clazz

	CsvLoader(Class<T> clazz) {
		this.clazz = clazz
	}

	List<T> loadAll(Path csvPath) {
		List<T> recursos = carregarRecursos(csvPath)
		return recursos
	}

	private List<T> carregarRecursos(Path csvPath) {
		HeaderColumnNameMappingStrategy ms = new HeaderColumnNameMappingStrategy()
		ms.setType(this.clazz)

		CSVParser parser = new CSVParserBuilder()
				.withSeparator(this.separator)
				.withIgnoreQuotations(true)
				.build()

		BufferedReader reader = Files.newBufferedReader(csvPath, StandardCharsets.ISO_8859_1)
		CSVReader csvReader = new CSVReaderBuilder(reader)
				.withSkipLines(0)
				.withCSVParser(parser)
				.build()

		CsvToBean cb = new CsvToBeanBuilder(csvReader)
				.withType(this.clazz)
				.withMappingStrategy(ms)
				.build()

		List<T> registros = cb.parse()

		reader.close()
		return registros
	}

}
