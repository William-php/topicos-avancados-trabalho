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
@Table(name = "servico")
public class Servico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "servico_id")
	private Long servicoId;
	
	@Column(name = "servico_nome")
	private String servicoNome;
	
	@Column(name = "servico_valor")
	private double servicoValor;
	
	@OneToMany(mappedBy = "servico")
	private List<ServicoAgendado> servicoAgendado;
	
	public Servico() {}
	
	public Servico(String nome, double valor) {
		this.servicoNome = nome;
		this.servicoValor = valor;
	}

	public Long getServicoId() {
		return servicoId;
	}

	public void setServicoId(Long servicoId) {
		this.servicoId = servicoId;
	}

	public String getServicoNome() {
		return servicoNome;
	}

	public void setServicoNome(String servicoNome) {
		this.servicoNome = servicoNome;
	}

	public double getServicoValor() {
		return servicoValor;
	}

	public void setServicoValor(double servicoValor) {
		this.servicoValor = servicoValor;
	}
	
	
}
