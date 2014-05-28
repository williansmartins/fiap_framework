package br.com.exemplo.vendas.negocio.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.exemplo.vendas.negocio.model.vo.ClienteVO;

@Entity
@Table(name="TBL_CLIENTE")
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(name="nome", nullable=false)
	private String nome;
	
	@Column(name="endereco")
	private String endereco;
	
	@Column(name="cidade")
	private String cidade;
	
	@Column(name="estado")
	private String estado;
	
	@Column(name="cnpj")
	private String cnpj;
	
	public Cliente(){}
	public Cliente(String nome, String cnpj){
		this.nome = nome;
		this.cnpj = cnpj;
	}
	public Cliente(String nome, String endereco, String cidade, String estado, String cnpj){
		this.nome = nome;
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
		this.cnpj = cnpj;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Cliente other = (Cliente) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	public static Cliente create(ClienteVO vo){
		Cliente cliente = new Cliente();
		cliente.setNome(vo.getNome());
		cliente.setEndereco(vo.getEndereco());
		cliente.setCidade(vo.getCidade());
		cliente.setEstado(vo.getEstado());
		cliente.setCnpj(vo.getCnpj());
		return cliente;
	}
	
	public static ClienteVO create(Cliente cliente){
		ClienteVO vo = new ClienteVO();
		vo.setNome(cliente.getNome());
		vo.setEndereco(cliente.getEndereco());
		vo.setCidade(cliente.getCidade());
		vo.setEstado(cliente.getEstado());
		vo.setCnpj(cliente.getCnpj());
		return vo;
	}
}