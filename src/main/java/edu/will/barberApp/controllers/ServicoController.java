package edu.will.barberApp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.will.barberApp.models.Servico;
import edu.will.barberApp.repositories.ServicoRepository;

@RestController
@RequestMapping(value = "servico")
public class ServicoController {
	@Autowired
	private ServicoRepository servicoRepository;
	
	@GetMapping(value = "/lista")
	public List<Servico> listaServico() {
		return this.servicoRepository.findAll();
	}
	
	@PostMapping
	public Servico salvar(@RequestBody Servico s) {
		return this.servicoRepository.save(s);
	}
	
	@GetMapping(value = "/{id}")
	public Servico servicoPorId(@PathVariable Long id) {
		Optional<Servico> s = this.servicoRepository.findById(id);
		
		return s.orElseThrow(() -> new RuntimeException("Deu ruim"));
	}
	
	@PutMapping(value = "/{id}")
	public Servico atualizar(@RequestBody Servico s, @PathVariable Long id) {
		Servico newS = this.servicoPorId(id);
		newS.setServicoNome(s.getServicoNome());
		newS.setServicoValor(s.getServicoValor());
		return this.servicoRepository.save(newS);
	}
	
	@DeleteMapping(value = "/{id}")
	public void apagar(@PathVariable Long id) {
		this.servicoRepository.deleteById(id);
	}
}
