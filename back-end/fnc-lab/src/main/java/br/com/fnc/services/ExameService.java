package br.com.fnc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fnc.domain.Exame;
import br.com.fnc.domain.Paciente;
import br.com.fnc.dtos.ExameDTO;
import br.com.fnc.repositories.ExameRepository;
import br.com.fnc.services.exceptions.ObjectNotFoundException;

@Service
public class ExameService {

	@Autowired
	private ExameRepository repository;
	
	@Autowired
	private ExameService service;
	
	@Autowired
	private PacienteService pacienteService;
	

	
	// faz a busca da categoria pelo ID
		public Exame findById(Integer id) {

			
			Optional<Exame> obj = repository.findById(id); // passa menssagem de erro quando não encontra o objeto
			return obj.orElseThrow(() -> new ObjectNotFoundException(
					"Objeto não encontrado! " + id + ",tipo: " + Exame.class.getName()));

		}

		public List<Exame> findAll() {
			return repository.findAll();
			
		}

		public Exame create(ExameDTO obj) {		
			return fromDTO(obj);
		}
		
		private  Exame fromDTO(ExameDTO obj) {
			Exame newObj = new Exame();
			newObj.setId(obj.getId());
			newObj.setDataColeta(obj.getDataColeta());
			newObj.setDataResultado(obj.getDataResultado());
			
			Paciente pac = pacienteService.findById(obj.getPaciente());
			newObj.setPaciente(pac);
			
			return repository.save(newObj);
		}
}
