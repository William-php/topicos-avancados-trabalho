package edu.will.barberApp.controllers;


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
	
	@Autowired
	BarbeiroController bController;
	
	@Autowired
	ClienteController cController;
	
	@Autowired 
	ServicoController sController;
	
	
	@PostMapping
	public ServicoAgendado salvar(@RequestBody ServicoAgendado servicoAgendado) {
		return this.servicoAgendadoRepository.save(servicoAgendado);
	}
	
	@GetMapping(value = "/{id}")
	public ServicoAgendadoFront servicoAgendadoPorId(@PathVariable Long id) {
		Optional<ServicoAgendado> s = this.servicoAgendadoRepository.findById(id);
		ServicoAgendado s1 = s.orElseThrow();
		ServicoAgendadoFront sFront =  null;
		if (s1 != null) {
			
			 Barbeiro b = bController.barbeiroPorId(s1.getBarbeiro().getBarbeiroId());
			 Cliente c = cController.clientesPorId(s1.getCliente().getClienteId());
			 Servico serv = sController.servicoPorId(s1.getServico().getServicoId());
			 
			 sFront = new ServicoAgendadoFront(b.getBarbeiroNome(), c.getClienteNome(), serv.getServicoNome(),
					 s1.getServicoData(), s1.getServicoHora());
		}
		
		return sFront;
		
	}
	
	@GetMapping(value = "/lista")
	public List<ServicoAgendado> listaServicos() {
		return this.servicoAgendadoRepository.findAll();
	}
}
