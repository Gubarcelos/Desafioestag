package br.com.fnc.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.fnc.domain.Paciente;
import br.com.fnc.dtos.PacienteDTO;
import br.com.fnc.services.PacienteService;

@RestController
@RequestMapping(value = "/pacientes")  //classe para busca GET de pacientes
public class PacienteResource {
	
	@Autowired
	private PacienteService service;
	
	@GetMapping(value = "/{id}")	
	public ResponseEntity<Paciente> findById(@PathVariable Integer id){
		Paciente obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	//localhost:8080/pacientes/id	
	
	@GetMapping
	public ResponseEntity<List<PacienteDTO>> findAll(){
		
		List<Paciente> list = service.findAll();	
		List<PacienteDTO> listDTO = list.stream().map(obj -> new PacienteDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok(listDTO);
	}
	
	@PostMapping  //http post
	public ResponseEntity<Paciente> create(@RequestBody Paciente obj){
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
