package br.com.exemplo.vendas.negocio.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_NOTA_FISCAL_SERVICO")
public class Boleto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String codigoBarra;
	
	@Column(name="nome_banco", nullable=false)
	private String nomeBanco;
	
	@Column(name="observacao", nullable=false)
	private String observacao;
	
	@Column(name="data_documento", nullable=false)
	private Calendar dataDocumento;
	
	@Column(name="data_vencimento", nullable=false)
	private Calendar dataVencimento;
	
	@Column(name="valor_documento", nullable=false)
	private BigDecimal valorDocumento;
	
	@Column(name="multa", nullable=false)
	private BigDecimal multa;
	
	@Column(name="valor_cobrado", nullable=false)
	private BigDecimal valorCobrado;
	
	public Boleto(){}
	public Boleto(String codigoBarra){
		this.codigoBarra = codigoBarra;
	}
	public Boleto(String codigoBarra, String nomeBanco, String observacao, Calendar dataDocumento, Calendar dataVencimento, BigDecimal valorDocumento, BigDecimal multa, BigDecimal valorCobrado){
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codigoBarra == null) ? 0 : codigoBarra.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Boleto other = (Boleto) obj;
		if (codigoBarra == null) {
			if (other.codigoBarra != null)
				return false;
		} else if (!codigoBarra.equals(other.codigoBarra))
			return false;
		return true;
	}
}