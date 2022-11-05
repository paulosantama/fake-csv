package org.example.dataload

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.example.domain.CsvWpd
import org.example.domain.EmpresaMedicaCsvWpd
import org.example.helpers.CsvWriter

import java.nio.file.Path

@Slf4j
@CompileStatic
class CsvWpdWriter {

	private static final CsvWriter<CsvWpd> WRITER_ITENS = new CsvWriter<>(CsvWpd)
	private static final CsvWriter<EmpresaMedicaCsvWpd> WRITER_EM = new CsvWriter<>(EmpresaMedicaCsvWpd)

	void escreverRegistrosItens(List<CsvWpd> itens, Path csvPath) {
		String nomeArquivo = csvPath.getFileName().toString()

		log.info("Encontrou o arquivo `${nomeArquivo}`.")

		try {
			escrevaRegistrosItens(itens, csvPath)
		} catch (Exception e) {
			log.error("Ocorreu um erro ao importar o arquivo `${nomeArquivo}`", e)
			log.info("Avançando para próximo arquivo")
		}
	}

	void escreverRegistrosEm(List<EmpresaMedicaCsvWpd> em, Path csvPath) {
		String nomeArquivo = csvPath.getFileName().toString()

		log.info("Encontrou o arquivo `${nomeArquivo}`.")

		try {
			escrevaRegistrosEmpresasMedicas(em, csvPath)
		} catch (Exception e) {
			log.error("Ocorreu um erro ao importar o arquivo `${nomeArquivo}`", e)
			log.info("Avançando para próximo arquivo")
		}
	}

	protected void escrevaRegistrosItens(List<CsvWpd> itens, Path path) {
		log.info("Iniciando escrita dos registros de itens...")
		WRITER_ITENS.writeAll(itens, path)
		log.info("Escrita de itens finalizada com ${itens.size()} registros escritos")
	}

	protected void escrevaRegistrosEmpresasMedicas(List<EmpresaMedicaCsvWpd> em, Path path) {
		log.info("Iniciando escrita dos registros de empresa médica...")
		WRITER_EM.writeAll(em, path)
		log.info("Escrita de empresas médicas finalizada com ${em.size()} registros escritos")
	}

}
