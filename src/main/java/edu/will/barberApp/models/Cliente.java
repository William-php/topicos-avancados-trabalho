package edu.will.barberApp.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cliente_id")
	private Long clienteId;
	
	@Column(name = "cliente_nome")
	private String clienteNome;
	
	@Column(name = "cliente_telefone")
	private String clienteTelefone;
	
	@Column(name = "cliente_email")
	private String clienteEmail;
	
	@OneToMany(mappedBy = "cliente")
	private List<ServicoAgendado> servicoAgendado;
	
	public Cliente() {}
	
	public Cliente(String nome, String email, String telefone) {
		this.clienteNome = nome;
		this.clienteEmail = email;
		this.clienteTelefone = telefone;
	}
	
	

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public String getClienteNome() {
		return clienteNome;
	}

	public void setClienteNome(String clienteNome) {
		this.clienteNome = clienteNome;
	}

	public String getClienteTelefone() {
		return clienteTelefone;
	}

	public void setClienteTelefone(String clienteTelefone) {
		this.clienteTelefone = clienteTelefone;
	}

	public String getClienteEmail() {
		return clienteEmail;
	}

	public void setClienteEmail(String clienteEmail) {
		this.clienteEmail = clienteEmail;
	}
	
	
}
