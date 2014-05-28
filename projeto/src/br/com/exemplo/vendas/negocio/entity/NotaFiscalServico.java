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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.exemplo.vendas.negocio.model.vo.NotaFiscalServicoVO;

@Entity
@Table(name="TBL_NOTA_FISCAL_SERVICO")
public class NotaFiscalServico implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String numero;
	
	@Column(name="discriminacao_geral", nullable=false)
	private String discriminacaoGeral;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data", nullable=false)
	private Calendar data;
	
	@Column(name="valor", nullable=false)
	private BigDecimal valor;
	
	public NotaFiscalServico(){}
	public NotaFiscalServico(String numero){
		this.numero = numero;
	}
	public NotaFiscalServico(String numero, String discriminacaoGeral, Calendar data, BigDecimal valor){
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		NotaFiscalServico other = (NotaFiscalServico) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}
	
	public static NotaFiscalServico create(NotaFiscalServicoVO vo){
		NotaFiscalServico nfs = new NotaFiscalServico();
		nfs.setNumero(vo.getNumero());
		nfs.setDiscriminacaoGeral(vo.getDiscriminacaoGeral());
		nfs.setData(vo.getData());
		nfs.setValor(vo.getValor());
		return nfs;
	}
	
	public static NotaFiscalServicoVO create(NotaFiscalServico nfs){
		NotaFiscalServicoVO vo = new NotaFiscalServicoVO();
		vo.setNumero(nfs.getNumero());
		vo.setDiscriminacaoGeral(nfs.getDiscriminacaoGeral());
		vo.setData(nfs.getData());
		vo.setValor(nfs.getValor());
		return vo;
	}
}