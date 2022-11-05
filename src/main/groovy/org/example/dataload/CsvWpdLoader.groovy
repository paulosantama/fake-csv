package org.example.dataload

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.example.domain.CsvWpd
import org.example.domain.EmpresaMedicaCsvWpd
import org.example.helpers.CsvLoader

import java.nio.file.Path
import java.nio.file.Paths

@Slf4j
@CompileStatic
class CsvWpdLoader {

	private static final CsvLoader<CsvWpd> LOADER_ITENS = new CsvLoader<>(CsvWpd)
	private static final CsvLoader<EmpresaMedicaCsvWpd> LOADER_EM = new CsvLoader<>(EmpresaMedicaCsvWpd)

	List<CsvWpd> obterRegistrosItens(String caminhoCsv) {
		log.info("Iterando arquivos no diretório ${caminhoCsv} para obter os CSVs")
		Path csvPath = Paths.get(caminhoCsv)
		String nomeArquivo = csvPath.getFileName().toString()

		log.info("Encontrou o arquivo `${nomeArquivo}`.")

		List<CsvWpd> list = null
		try {
			list = obtemRegistrosItens(csvPath)
		} catch (Exception e) {
			log.error("Ocorreu um erro ao importar o arquivo `${nomeArquivo}`!", e)
			log.info("Avançando para próximo arquivo")
		}
		return list
	}

	List<EmpresaMedicaCsvWpd> obterRegistrosEm(String caminhoCsv) {
		log.info("Iterando arquivos no diretório ${caminhoCsv} para obter os CSVs")
		Path csvPath = Paths.get(caminhoCsv)
		String nomeArquivo = csvPath.getFileName().toString()

		log.info("Encontrou o arquivo `${nomeArquivo}`.")

		List<EmpresaMedicaCsvWpd> list = null
		try {
			list = obtemRegistrosEmpresasMedicas(csvPath)
		} catch (Exception e) {
			log.error("Ocorreu um erro ao importar o arquivo `${nomeArquivo}`!", e)
			log.info("Avançando para próximo arquivo")
		}
		return list
	}

	List<CsvWpd> obtemRegistrosItens(Path csvPath) {
		log.info("Iniciando carga dos registros de itens...")
		final List<CsvWpd> list = LOADER_ITENS.loadAll(csvPath)
		log.info("Obtenção finalizada com ${list.size()} registros obtidos")
		return list
	}

	List<EmpresaMedicaCsvWpd> obtemRegistrosEmpresasMedicas(Path csvPath) {
		log.info("Iniciando carga dos registros de empresas médicas...")
		final List<EmpresaMedicaCsvWpd> list = LOADER_EM.loadAll(csvPath)
		log.info("Obtenção de empresas médicas finalizada com ${list.size()} registros obtidos")
		return list
	}

}
