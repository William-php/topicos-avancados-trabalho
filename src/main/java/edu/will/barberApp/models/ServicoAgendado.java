package edu.will.barberApp.models;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "servico_agendado")
public class ServicoAgendado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "servico_agendado_id")
	private Long servicoAgendadoId;
//	DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("YYYY-MM-DD hh:mm:ss");
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ManyToOne
	@JoinColumn(name = "barbeiro_id")
	private Barbeiro barbeiro;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ManyToOne
	@JoinColumn(name = "servico_id")
	private Servico servico;
	
	@Column(name = "servico_data")
	private Date servicoData;
	
	@Column(name = "servico_hora")
	private Time servicoHora;
	
	public ServicoAgendado() {}
	
	public ServicoAgendado(Date data, Time hora) {
		this.servicoData = data;
		this.servicoHora = hora;
	}

	public Long getServicoAgendadoId() {
		return servicoAgendadoId;
	}

	public void setServicoAgendadoId(Long servicoAgendadoId) {
		this.servicoAgendadoId = servicoAgendadoId;
	}

	
	public Barbeiro getBarbeiro() {
		return barbeiro;
	}

	public void setBarbeiro(Barbeiro barbeiro) {
		this.barbeiro = barbeiro;
	}

	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@JsonIgnore
	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Date getServicoData() {
		return servicoData;
	}

	public void setServicoData(Date servicoData) {
		this.servicoData = servicoData;
	}

	public Time getServicoHora() {
		return servicoHora;
	}

	public void setServicoHora(Time servicoHora) {
		this.servicoHora = servicoHora;
	}



	
	
	
	
	
}
