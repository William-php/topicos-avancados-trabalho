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
@Table(name = "cliente")
public class Cliente extends Usuario{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cliente_id")
	private Long id;

	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<ServicoAgendado> servicoAgendado = new ArrayList<ServicoAgendado>();
	
	public Cliente() {}
	public Cliente(String nome, String sobrenome, String telefone, String email) {
		super(nome, sobrenome, telefone, email);
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
