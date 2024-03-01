package edu.will.barberApp.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.will.barberApp.models.Barbeiro;
import edu.will.barberApp.models.Usuario;
import edu.will.barberApp.repositories.BarbeiroRepository;


@RestController
@RequestMapping(value = "/barbeiros")
public class BarbeiroController {
	@Autowired
	private BarbeiroRepository barbeiroRepository;
	
	
	
	@GetMapping(value = "/lista") //Mapeia URL
	public List<Barbeiro> listaBarbeiros() {
		
		List<Barbeiro> barbeiros = barbeiroRepository.findAll();
		
//		
		return barbeiros;
	}
	
	@GetMapping(value = "/nome/{nome}")
	public List<Barbeiro> barbeiroPorNome(@PathVariable String nome) {
		
		
		List<Barbeiro> barbeiros = barbeiroRepository.findByName(nome);
		
		return barbeiros;
	}
	
	@GetMapping(value = "/nome-sobrenome/{nome}/{sobrenome}")
	public Barbeiro barbeiroPorNome(@PathVariable String nome, @PathVariable String sobrenome) {
		
		
		Barbeiro barbeiro = barbeiroRepository.findBynomeSobrenome(nome, sobrenome);
		System.out.println(barbeiro);
		//System.out.println(barbeiro.getSobrenome());
		return barbeiro;
	}
	
	@GetMapping(value = "/{id}")
	public Barbeiro barbeiroPorId(@PathVariable Long id) {
		Optional<Barbeiro> barbeiro = barbeiroRepository.findById(id);
		
		return barbeiro.orElseThrow(() -> new RuntimeException(
				"Barbeiro não encontrado por id: " + id
		));
	}
	
	@PostMapping //Mapeia URL
	@ResponseBody
	public ResponseEntity<Barbeiro> salvar(@RequestBody Barbeiro barbeiro) {
		Barbeiro b = this.barbeiroRepository.save(barbeiro); 
		return new ResponseEntity<Barbeiro>(b, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{id}")
	public Barbeiro atualizar(@RequestBody Barbeiro b, @PathVariable Long id) {
		Barbeiro newB = this.barbeiroPorId(id);
		newB.setEmail(b.getEmail());
		newB.setNome(b.getNome());
		newB.setTelefone(b.getTelefone());		
		return this.barbeiroRepository.save(newB); 
	}
	
	@DeleteMapping(value = "/{id}")
	public void apagar(@PathVariable Long id) {
		this.barbeiroRepository.deleteById(id);
	}
	
	
}
