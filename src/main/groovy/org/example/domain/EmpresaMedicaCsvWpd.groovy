package org.example.domain

import com.opencsv.bean.CsvBindByName
import groovy.transform.CompileStatic

@CompileStatic
class EmpresaMedicaCsvWpd {

	@CsvBindByName(column = "EMPRESA_NOME")
	String empresaNome

	@CsvBindByName(column = "EMPRESA_CNPJ")
	String empresaCnpj

	@CsvBindByName(column = "EMPRESA_EMAIL")
	String empresaEmail

	@CsvBindByName(column = "EMPRESA_COD_FORNECEDOR")
	String empresaCodFornecedor

}
