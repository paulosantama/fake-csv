package org.example.helpers

import com.opencsv.bean.StatefulBeanToCsv
import com.opencsv.bean.StatefulBeanToCsvBuilder
import groovy.transform.CompileStatic

import java.nio.file.Path

@CompileStatic
class CsvWriter<T> {

	char separator = ';'
	Class<T> clazz

	CsvWriter(Class<T> clazz) {
		this.clazz = clazz
	}

	void writeAll(List<T> data, Path csvPath) {
		try(Writer writer = new FileWriter(csvPath.toString())) {
			StatefulBeanToCsv<T> sbc = new StatefulBeanToCsvBuilder<T>(writer)
			.withSeparator(this.separator)
			.build()

			sbc.write(data)
		}
	}

}
