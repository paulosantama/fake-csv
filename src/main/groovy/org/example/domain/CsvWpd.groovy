package org.example.domain

import com.opencsv.bean.CsvBindByName
import groovy.transform.CompileStatic

@CompileStatic
class CsvWpd {

	@CsvBindByName(column = "COD_PAC")
	String codPac

	@CsvBindByName(column = "COD_PRT")
	String codPrt

	@CsvBindByName(column = "NOME_PAC")
	String nomePac

	@CsvBindByName(column = "DATA_ENT")
	String dataEnt

	@CsvBindByName(column = "DATA_ALTA")
	String dataAlta

	@CsvBindByName(column = "TIPO_PACIENTE")
	String tipoPac

	@CsvBindByName(column = "TIPO_ATENDIMENTO")
	String tipoAtendimento

	@CsvBindByName(column = "CARATER_ATENDIMENTO")
	String caraterAtendimento

	@CsvBindByName(column = "COD_CON")
	String codCon

	@CsvBindByName(column = "FANTASIA")
	String fantasia

	@CsvBindByName(column = "COD_PLA")
	String codPla

	@CsvBindByName(column = "NOME_PLANO")
	String nomePlano

	@CsvBindByName(column = "CNPJ_OPERADORA")
	String cnpjOperadora

	@CsvBindByName(column = "TIPO_COMANDA")
	String tipoComanda

	@CsvBindByName(column = "COMANDA")
	String comanda

	@CsvBindByName(column = "DATA_MOV")
	String dataMov

	@CsvBindByName(column = "REQ_DEV")
	String reqDev

	@CsvBindByName(column = "COD_PROD")
	String codProd

	@CsvBindByName(column = "DSC_PROD")
	String dscProd

	@CsvBindByName(column = "TIPO_PRD")
	String tipoPrd

	@CsvBindByName(column = "DSC_TIPO_PROD")
	String dscTipoProd

	@CsvBindByName(column = "CO_TUSS")
	String coTuss

	@CsvBindByName(column = "QUANT")
	String quant

	@CsvBindByName(column = "NUM_GUIA")
	String numGuia

	@CsvBindByName(column = "TIPO_GUIA")
	String tipoGuia

	@CsvBindByName(column = "COD_TPGUIA_TISS")
	String codTpguiaTiss

	@CsvBindByName(column = "SET_ORI")
	String setOri

	@CsvBindByName(column = "DSC_SET_ORI")
	String dscSetOri

	@CsvBindByName(column = "TIP_ACOM_WPD")
	String tipAcomWpd

	@CsvBindByName(column = "DSC_ACOM_WPD")
	String dscAcomWpd

	@CsvBindByName(column = "TIP_ACOM_TISS")
	String tipAcomTiss

	@CsvBindByName(column = "DSC_ACOM_TISS")
	String dscAcomTiss

	@CsvBindByName(column = "COD_PRO")
	String codPro

	@CsvBindByName(column = "NOME_PRO")
	String nomePro

	@CsvBindByName(column = "CONSELHO")
	String conselho

	@CsvBindByName(column = "NU_CONSELHO")
	String nuConselho

	@CsvBindByName(column = "UF_CONSELHO")
	String ufConselho

	@CsvBindByName(column = "SEQUENCIAL")
	String sequencial

	@CsvBindByName(column = "TIPO_ATO")
	String tipoAto

	@CsvBindByName(column = "DSC_TIPO_ATO")
	String dscTipoAto

	@CsvBindByName(column = "COD_TIPOATO_TISS")
	String codTipoatoTiss

	@CsvBindByName(column = "PERC_ATO")
	String percAto

	@CsvBindByName(column = "PERCENTUAL")
	String percentual

	@CsvBindByName(column = "TIPO_ATO_TISS")
	String tipoAtoTiss

	@CsvBindByName(column = "COD_FATURA")
	String codFatura

	@CsvBindByName(column = "TIPO_FATURA")
	String tipoFatura

	@CsvBindByName(column = "DESTINO")
	String destino

	@CsvBindByName(column = "VALOR_UNITARIO")
	String valorUnitario

	@CsvBindByName(column = "VALOR_TOTAL")
	String valorTotal

	@CsvBindByName(column = "REMESSA")
	String remessa

	@CsvBindByName(column = "DEST_FAT")
	String destFat

	@CsvBindByName(column = "DATA_EMI_FAT")
	String dataEmiFat

	@CsvBindByName(column = "DATA_INI_FAT")
	String dataIni

	@CsvBindByName(column = "DATA_FIN_FAT")
	String dataFin

	@CsvBindByName(column = "QUITADA")
	String quitada

	@CsvBindByName(column = "FATURA_FECHADA")
	String faturaFechada

	@CsvBindByName(column = "DESTINO_FATURA")
	String destinoFatura

	@CsvBindByName(column = "COD_UNI")
	String codUni

	@CsvBindByName(column = "NOME_UNI")
	String nomeUni

}
