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

import edu.will.barberApp.models.Cliente;
import edu.will.barberApp.repositories.ClienteRepository;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping(value = "/lista")
	public List<Cliente> listaCliente() {
		return this.clienteRepository.findAll();
	}
	
	@PostMapping
	public Cliente salvar(@RequestBody Cliente c) {
		return this.clienteRepository.save(c);
	}
	
	@GetMapping(value = "/{id}")
	public Cliente clientesPorId(@PathVariable Long id) {
		Optional<Cliente> c = this.clienteRepository.findById(id);
		
		
		return c.orElseThrow(()-> new RuntimeException(
				"Cliente não encontrado pelo id: "+ id
				));
	}
	
	@PutMapping(value = "/{id}")
	public Cliente atualizar(@RequestBody Cliente c, @PathVariable Long id) {
		Cliente newC = this.clientesPorId(id);
		newC.setClienteEmail(c.getClienteEmail());
		newC.setClienteNome(c.getClienteNome());
		newC.setClienteTelefone(c.getClienteTelefone());
		return this.clienteRepository.save(newC);
	}
	
	@DeleteMapping(value = "/{id}")
	public void apagar(@PathVariable Long id) {
		this.clienteRepository.deleteById(id);
	}
	
}
