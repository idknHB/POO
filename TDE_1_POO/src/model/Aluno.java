package model;

public class Aluno {
	
	//atributos
	private int matricula;
	private String nome;
	
	//atributos de relacionamento
	private Curso curso;
	
	//metodos
	public Aluno(int matricula, String nome, Curso curso) throws ModelException{
		this.setMatricula(matricula);
		this.setNome(nome);
		this.setCurso(curso);
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) throws ModelException{
		Aluno.validarMatricula(matricula);
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws ModelException{
		Aluno.validarNome(nome);
		this.nome = nome;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) throws ModelException{
		Aluno.validarCurso(curso);
		
		if(this.curso != null) {
			this.curso.removerAluno(this);
		}
		
		//Associa o aluno ao novo curso
		this.curso = curso;
		this.curso.adicionarAluno(this);
	}
	
	//metodos de validação
	public static void validarMatricula(int matricula) throws ModelException {
		if (matricula <= 0) {
			throw new ModelException("A matrícula do aluno deve ser maior que zero!");
			}
		}
	
	public static void validarNome(String nome) throws ModelException{
		if(nome == null || nome.trim().isEmpty()) {
			throws new ModelException("O nome não pode estar nulo ou vazio.");
		}
	}
	
	public static void validarCurso(Curso curso) throws ModelException{
		if(curso == null) {
			throws new ModelException("O aluno deve estar obrigatoriamente em um curso.");
		}
	}
	
}
