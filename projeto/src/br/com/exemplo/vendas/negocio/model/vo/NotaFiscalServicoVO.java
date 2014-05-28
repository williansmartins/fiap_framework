package br.com.exemplo.vendas.negocio.model.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

public class NotaFiscalServicoVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String numero;
	private String discriminacaoGeral;
	private Calendar data;
	private BigDecimal valor;
	
	public NotaFiscalServicoVO(){}
	public NotaFiscalServicoVO(String numero){
		this.numero = numero;
	}
	public NotaFiscalServicoVO(String numero, String discriminacaoGeral, Calendar data, BigDecimal valor){
		this.numero = numero;
		this.discriminacaoGeral = discriminacaoGeral;
		this.data = data;
		this.valor = valor;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getDiscriminacaoGeral() {
		return discriminacaoGeral;
	}
	public void setDiscriminacaoGeral(String discriminacaoGeral) {
		this.discriminacaoGeral = discriminacaoGeral;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
}