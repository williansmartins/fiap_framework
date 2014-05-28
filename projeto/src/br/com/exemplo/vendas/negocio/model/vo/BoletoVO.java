package br.com.exemplo.vendas.negocio.model.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

public class BoletoVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String codigoBarra;
	private String nomeBanco;
	private String observacao;
	private Calendar dataDocumento;
	private Calendar dataVencimento;
	private BigDecimal valorDocumento;
	private BigDecimal multa;
	private BigDecimal valorCobrado;
	
	public BoletoVO(){}
	public BoletoVO(String codigoBarra){
		this.codigoBarra = codigoBarra;
	}
	public BoletoVO(String codigoBarra, String nomeBanco, String observacao, Calendar dataDocumento, Calendar dataVencimento, BigDecimal valorDocumento, BigDecimal multa, BigDecimal valorCobrado){
		this.codigoBarra = codigoBarra;
		this.nomeBanco = nomeBanco;
		this.observacao = observacao;
		this.dataDocumento = dataDocumento;
		this.dataVencimento = dataVencimento;
		this.valorDocumento = valorDocumento;
		this.multa = multa;
		this.valorCobrado = valorCobrado;
	}
	public String getCodigoBarra() {
		return codigoBarra;
	}
	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}
	public String getNomeBanco() {
		return nomeBanco;
	}
	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public Calendar getDataDocumento() {
		return dataDocumento;
	}
	public void setDataDocumento(Calendar dataDocumento) {
		this.dataDocumento = dataDocumento;
	}
	public Calendar getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(Calendar dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public BigDecimal getValorDocumento() {
		return valorDocumento;
	}
	public void setValorDocumento(BigDecimal valorDocumento) {
		this.valorDocumento = valorDocumento;
	}
	public BigDecimal getMulta() {
		return multa;
	}
	public void setMulta(BigDecimal multa) {
		this.multa = multa;
	}
	public BigDecimal getValorCobrado() {
		return valorCobrado;
	}
	public void setValorCobrado(BigDecimal valorCobrado) {
		this.valorCobrado = valorCobrado;
	}
}