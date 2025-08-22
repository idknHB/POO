package model;

import java.util.ArrayList;

public class Curso {
	
	//atributos

	private int codigo;
	private String nome;
	
	//atributos de relacionamento
	
	private ArrayList<Aluno> listaAlunos;
	
	//metodos
	
	public Curso(int codigo, String nome) throws ModelException {
		this.setCodigo(codigo);
		this.setNome(nome);
		this.listaAlunos = new ArrayList<>();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		Curso.validarCodigo(codigo);
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		Curso.validarNome(nome);
		this.nome = nome;
	}

	public ArrayList<Aluno> getListaAlunos() {
		return listaAlunos;
	}

	public void adicionarAluno(Aluno aluno) throws ModelException{
		if(aluno == null) {
			throws new ModelException("Aluno não pode ser nulo ao ser adicionado.");
		}
		this.listaAlunos.add(aluno);
	}
	
	public void removerAluno(Aluno aluno) throws ModelException{
		if(aluno == null) {
			throws new ModelException("Aluno não pode ser nulo ao ser removido.");
		}
		this.listaAlunos.remove(aluno);
	}
	
	public String toString() {
		return this.nome;
	}
	
	public static void validarCodigo(int codigo) throws ModelException{
		if(codigo <=0) {
			throws new ModelException("O codigo do curso deve ser maior que 0.");
		}
	}
	
	public static void validarNome(String nome) throws ModelException{
		if(nome == null || nome.trim().isEmpty()) {
			throws new ModelException("O nome do curso não pode ser nulo ou vazio.");
		}
	}
}
