package br.com.fnc.resources;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import br.com.fnc.dtos.ExameDTO;
import br.com.fnc.services.ExameService;

@RestController
@RequestMapping(value = "/exames") // classe para busca GET de exame
public class ExameResource {

	@Autowired
	private ExameService service;

	
	// Metodo padrão DTO: para listar apenas os pacientes
	@GetMapping(value = "/{id}")
	public ResponseEntity<ExameDTO> findById(@PathVariable Integer id){
		
		ExameDTO obj = new ExameDTO(service.findById(id));
		return ResponseEntity.ok().body(obj);
		//localhost:8080/exames?pacientes=1
	}
	
	@GetMapping
	public ResponseEntity<List<ExameDTO>> findAll(){
		List<ExameDTO> list =service.findAll().stream().map(obj -> new ExameDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(list);
	}
								
		
}
