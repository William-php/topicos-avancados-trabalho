package edu.will.barberApp.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "barbeiro")

public class Barbeiro extends Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "barbeiro_id")
	private Long id;
	
	

	@JsonIgnore
	@OneToMany(mappedBy = "barbeiro")
	private List<ServicoAgendado> servicoAgendado = new ArrayList<ServicoAgendado>();
	
	public Barbeiro() {}
	public Barbeiro(String nome, String sobrenome, String email, String telefone) {
		super(nome, sobrenome, email, telefone);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public List<ServicoAgendado> getServicoAgendado() {
		return servicoAgendado;
	}
	
	public void setServicoAgendado(List<ServicoAgendado> servicoAgendado) {
		this.servicoAgendado = servicoAgendado;
	}
	
	
}
