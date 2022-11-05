package org.example.service

import com.github.javafaker.Faker
import org.example.dataload.CsvWpdLoader
import org.example.dataload.CsvWpdWriter
import org.example.domain.CsvWpd
import org.example.domain.EmpresaMedicaCsvWpd

import java.nio.file.Path
import java.nio.file.Paths

class CsvWpdFakerService {

	CsvWpdLoader loader
	CsvWpdWriter writer

	Faker faker

	CsvWpdFakerService() {
		this.loader = new CsvWpdLoader()
		this.writer = new CsvWpdWriter()
		this.faker = new Faker(new Locale('pt-BR'))
	}

	void fakear() {
//		fakearEmpresa(
//				Paths.get('/home/paulosilva/Downloads/santajoana/empresamedica_santajoana1.csv'),
//				Paths.get('/home/paulosilva/Downloads/santajoana/empresamedica_santajoana1-masked.csv')
//		)
//		fakearEmpresa(
//				Paths.get('/home/paulosilva/Downloads/santajoana/empresamedica_santajoana2.csv'),
//				Paths.get('/home/paulosilva/Downloads/santajoana/empresamedica_santajoana2-masked.csv')
//		)
//		fakearProfissionalEPaciente(
//				Paths.get('/home/paulosilva/Downloads/santajoana/santajoana1.csv'),
//				Paths.get('/home/paulosilva/Downloads/santajoana/santajoana1-masked.csv')
//		)
//		fakearProfissionalEPaciente(
//				Paths.get('/home/paulosilva/Downloads/santajoana/santajoana2.csv'),
//				Paths.get('/home/paulosilva/Downloads/santajoana/santajoana2-masked.csv')
//		)
	}

	void fakearEmpresa(Path origem, Path destino) {
		List<EmpresaMedicaCsvWpd> emList = this.loader.obtemRegistrosEmpresasMedicas(origem)
		Set<String> emNomesFake = []
		while (emNomesFake.size() < emList.size()) {
			emNomesFake << this.faker.company().name()
		}
		emList.eachWithIndex { EmpresaMedicaCsvWpd em, int i ->
			em.empresaNome = emNomesFake[i]
		}

		this.writer.escreverRegistrosEm(emList, destino)
	}

	void fakearProfissionalEPaciente(Path origem, Path destino) {
		List<CsvWpd> itensList = this.loader.obtemRegistrosItens(origem)

		// mascarar nomes profissionais
		Map<String, List<CsvWpd>> agrupadosPorProfissional = itensList.groupBy { it.codPro }
		Set<String> itensNomeProfissionalFake = []
		while (itensNomeProfissionalFake.size() < agrupadosPorProfissional.size()) {
			itensNomeProfissionalFake << this.faker.name().fullName().toUpperCase()
		}
		agrupadosPorProfissional.eachWithIndex { Map.Entry<String, List<CsvWpd>> entry, int i ->
			String novoNomePro = itensNomeProfissionalFake[i]
			entry.value*.nomePro = novoNomePro
		}

		// mascarar nomes pacientes
		Map<String, List<CsvWpd>> agrupadosPorPaciente = itensList.groupBy { it.codPrt }
		Set<String> itensNomePacienteFake = []
		while (itensNomePacienteFake.size() < agrupadosPorPaciente.size()) {
			itensNomePacienteFake << "${this.faker.name().firstName()} ${this.faker.name().lastName()}".toUpperCase()
		}
		agrupadosPorPaciente.eachWithIndex { Map.Entry<String, List<CsvWpd>> entry, int i ->
			entry.value*.nomePac = itensNomePacienteFake[i]
		}

		this.writer.escreverRegistrosItens(itensList, destino)
	}

}
