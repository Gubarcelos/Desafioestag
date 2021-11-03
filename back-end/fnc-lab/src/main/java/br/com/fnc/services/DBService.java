package br.com.fnc.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fnc.domain.Exame;
import br.com.fnc.domain.Paciente;
import br.com.fnc.domain.Procedimento;
import br.com.fnc.repositories.ExameRepository;
import br.com.fnc.repositories.PacienteRepository;
import br.com.fnc.repositories.ProcedimentoRepository;

@Service
public class DBService {
	
	@Autowired
	private PacienteRepository pacienteReposytory;
	@Autowired
	private ExameRepository exameReposytory;
	@Autowired
	private ProcedimentoRepository procedimentoReposytory;

	public void instanciaBaseDeDados() {
		
		Paciente pc1 = new Paciente(null, "Maria Aparecida", "422.374.228-00", "maria.123@123.com");
		Paciente pc2 = new Paciente(null, "Maria Aparecida", "422.374.228-00", "maria.123@123.com");
		
		
		Exame ex1 = new Exame(null, pc1, "12/10/2021", "11/11/20221");
		Exame ex2 = new Exame(null, pc2, "12/10/2021", "11/11/20221");
		
		
		Procedimento pr1 = new Procedimento(null, "Analise sanguinea", "5 dias", ex1);
		Procedimento pr2 = new Procedimento(null, "Analise sanguinea", "5 dias", ex1);
		
		Procedimento pr3 = new Procedimento(null, "teste de alergia", "5 dias", ex2);
		Procedimento pr4 = new Procedimento(null, "teste de alergia", "5 dias", ex2);
		
		
		pc1.getExames().addAll(Arrays.asList(ex1));
		ex1.getProcedimentos().addAll(Arrays.asList(pr1,pr2));
		
		pc2.getExames().addAll(Arrays.asList(ex2));
		ex2.getProcedimentos().addAll(Arrays.asList(pr2,pr3));
		
		
		this.pacienteReposytory.saveAll(Arrays.asList(pc1,pc2));
		this.exameReposytory.saveAll(Arrays.asList(ex1,ex2));
		this.procedimentoReposytory.saveAll(Arrays.asList(pr1,pr2,pr3,pr4));
		
	}
	
}
