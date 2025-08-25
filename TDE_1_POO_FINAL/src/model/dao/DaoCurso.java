package model.dao;

import java.util.ArrayList;
import model.Curso;

public class DaoCurso {
	
	private static ArrayList<Curso> listaCurso;
	
	static {
		DaoCurso.listaCurso = new ArrayList<>();
	}
	
	public boolean adicionar(Curso c) {
		return DaoCurso.listaCurso.add(c);
	}
	
	public ArrayList<Curso> obterTodos(){
		return new ArrayList<>(DaoCurso.listaCurso);
	}
}
