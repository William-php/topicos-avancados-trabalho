package edu.will.barberApp.controllers;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.will.barberApp.models.Barbeiro;
import edu.will.barberApp.models.Cliente;
import edu.will.barberApp.models.Servico;
import edu.will.barberApp.models.ServicoAgendado;
import edu.will.barberApp.models.ServicoAgendadoFront;
import edu.will.barberApp.repositories.ServicoAgendadoRepository;

@RestController
@RequestMapping(value = "/servicos_agendados")
public class ServicoAgendadoController {
	@Autowired
	private ServicoAgendadoRepository servicoAgendadoRepository;
	
//	@Autowired
//	BarbeiroController bController;
//	
//	@Autowired
//	ClienteController cController;
//	
//	@Autowired 
//	ServicoController sController;
	
	
	@PostMapping
	public ServicoAgendado salvar(@RequestBody ServicoAgendado servicoAgendado) {
		return this.servicoAgendadoRepository.save(servicoAgendado);
	}
	
	@GetMapping(value = "/{id}")
	public List<ServicoAgendadoFront> listaServicos(@PathVariable Long id) {
		List<ServicoAgendado> users = this.servicoAgendadoRepository.findServicoByBarbeiro(id);
		List<ServicoAgendadoFront> servicosDoBarber = new ArrayList<>();
		
					
		for (ServicoAgendado u:users) {
			ServicoAgendadoFront s = new ServicoAgendadoFront(
					u.getBarbeiro().getNome(),
					u.getCliente().getNome(),
					u.getServico().getServicoNome(),
					u.getServicoData(),
					u.getServicoHora() );
			
			System.out.println(s.toString());
			servicosDoBarber.add(s);
		}
		
		
		
		return servicosDoBarber.get(0);
	}
}
