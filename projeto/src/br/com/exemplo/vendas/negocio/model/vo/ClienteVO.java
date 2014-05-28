package br.com.exemplo.vendas.negocio.model.vo;

import java.io.Serializable;

public class ClienteVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long codigo;
	private String nome;
	private String endereco;
	private String cidade;
	private String estado;
	private String cnpj;
	
	public ClienteVO(){}
	public ClienteVO(String nome, String cnpj){
		this.nome = nome;
		this.cnpj = cnpj;
	}
	public ClienteVO(String nome, String endereco, String cidade, String estado, String cnpj){
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
}