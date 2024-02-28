package edu.will.barberApp.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "barbeiro")
public class Barbeiro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "barbeiro_id")
	private Long BarbeiroId;
	
	@Column(name = "barbeiro_nome")
	private String barbeiroNome;
	
	@Column(name = "barbeiro_telefone")
	private String barbeiroTelefone;
	
	@Column(name = "barbeiro_email")
	private String barbeiroEmail;
	public Barbeiro() {}
	public Barbeiro(String nome, String telefone, String email) {
		this.barbeiroNome = nome;
		this.barbeiroTelefone  = telefone;
		this.barbeiroEmail = email;
	}
	@JsonIgnore
	@OneToMany(mappedBy = "barbeiro")
	private List<ServicoAgendado> servicoAgendado;
	

	public Long getBarbeiroId() {
		return BarbeiroId;
	}

	public void setBarbeiroId(Long barbeiroId) {
		BarbeiroId = barbeiroId;
	}

	public String getBarbeiroNome() {
		return barbeiroNome;
	}

	public void setBarbeiroNome(String barbeiroNome) {
		this.barbeiroNome = barbeiroNome;
	}

	public String getBarbeiroTelefone() {
		return barbeiroTelefone;
	}

	public void setBarbeiroTelefone(String barbeiroTelefone) {
		this.barbeiroTelefone = barbeiroTelefone;
	}

	public String getBarbeiroEmail() {
		return barbeiroEmail;
	}

	public void setBarbeiroEmail(String barbeiroEmail) {
		this.barbeiroEmail = barbeiroEmail;
	}
	public List<ServicoAgendado> getServicoAgendado() {
		return servicoAgendado;
	}
	public void setServicoAgendado(List<ServicoAgendado> servicoAgendado) {
		this.servicoAgendado = servicoAgendado;
	}
	
	
}
