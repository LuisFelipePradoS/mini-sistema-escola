package cursojava.classes;

import java.util.List;
import java.util.ArrayList;

import cursojava.constantes.StatusAluno;

public class Aluno extends Pessoa{
	
	private String raAluno;
	private String serieMatriculada;
	private String dataMatricula;
	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();
	
	public String getRaAluno() {
		return raAluno;
	}
	public void setRaAluno(String raAluno) {
		this.raAluno = raAluno;
	}
	public String getSerieMatriculada() {
		return serieMatriculada;
	}
	public void setSerieMatriculada(String serieMatriculada) {
		this.serieMatriculada = serieMatriculada;
	}
	public String getDataMatricula() {
		return dataMatricula;
	}
	public void setDataMatricula(String dataMatricula) {
		this.dataMatricula = dataMatricula;
	}
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	@Override
	public String toString() {
		return "Aluno [raAluno=" + raAluno + ", serieMatriculada=" + serieMatriculada + ", dataMatricula="
				+ dataMatricula + ", disciplinas=" + disciplinas + ", nome=" + nome + ", idade=" + idade + ", cpf="
				+ cpf + ", rg=" + rg + ", telefone=" + telefone + ", endereco=" + endereco + "]";
	}
	
	public double calculaMediaFinal() {
		
		double somaNotas = 0.0;
		
		for (Disciplina disciplina : disciplinas) {
			
			somaNotas += disciplina.calculaMediaDisciplina();
		}
		
		return somaNotas / disciplinas.size();
	}
	
	public String resultado() {
		
		double mediaFinal = this.calculaMediaFinal();
		
		if (mediaFinal >= 5.0) {
			
			if (mediaFinal >= 7.0) {
				
				return StatusAluno.APROVADO;
			} else {
				
				return StatusAluno.RECUPERACAO;
				}
			
			} else {
				
				return StatusAluno.REPROVADO;
				
		}
	}
}
