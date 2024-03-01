package edu.will.barberApp.models;

import java.sql.Date;
import java.sql.Time;

public class ServicoAgendadoFront {
	private String barbeiroNome;
	private String clienteNome;
	private String servicoNome;
	private Date servicoAgendadoData;
	private Time servicoAgendadoHorario;
	
	public ServicoAgendadoFront() {}
	public ServicoAgendadoFront(String bNome, String cNome, String sNome, Date sData, Time sHora) {
		this.barbeiroNome = bNome;
		this.clienteNome = cNome;
		this.servicoNome = sNome;
		this.servicoAgendadoData = sData;
		this.servicoAgendadoHorario = sHora;
	}
	@Override
	public String toString() {
		return "ServicoAgendadoFront [barbeiroNome=" + barbeiroNome + ", clienteNome=" + clienteNome + ", servicoNome="
				+ servicoNome + ", servicoAgendadoData=" + servicoAgendadoData + ", servicoAgendadoHorario="
				+ servicoAgendadoHorario + "]";
	}
	
	
}
