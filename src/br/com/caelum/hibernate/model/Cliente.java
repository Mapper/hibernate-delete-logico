package br.com.caelum.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@SQLDelete(sql = "update Cliente set ativo = 0 where id = ?")
@Where(clause = "ativo = 1")
public class Cliente {

	@Id @GeneratedValue
	private Long id;
	private String nome;
	private String cpf;
	
	private Boolean ativo;
	
	public Cliente() {
		this.ativo = true;
	}
	
	public Cliente(String nome, String cpf) {
		this();
		this.nome = nome;
		this.cpf = cpf;
	}

	//GETTERS AND SETTERS
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
