package model.dao;

import java.util.ArrayList;

import model.Departamento;

public class DaoDepartamento {
	
	private static ArrayList<Departamento> listaDepartamentos;
	
	static {
		// TODO falar sobre carga de bytecodes e bloco static
		DaoDepartamento.listaDepartamentos = new ArrayList<Departamento>();
	}
	
	// TODO explicar por que não criamos um construtor
	
	public boolean adicionar(Departamento novo) {
		return DaoDepartamento.listaDepartamentos.add(novo);
	}

	public ArrayList<Departamento> obterTodos() {
		return new ArrayList(DaoDepartamento.listaDepartamentos);
	}
}
