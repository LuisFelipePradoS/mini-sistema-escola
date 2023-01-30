package cursojava.classes;

import java.util.List;
import java.util.ArrayList;

import cursojava.constantes.StatusAluno;

public class Aluno {

	private String nome;
	private int idade;
	private String cpf;
	private String rg;
	private String endereco;
	private String telefone;
	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", idade=" + idade + ", cpf=" + cpf + ", rg=" + rg + ", endereco=" + endereco
				+ ", telefone=" + telefone + ", disciplinas=" + disciplinas + "]";
	}
	
	public double calculaMedia() {
		
		double somaNotas = 0.0;
		
		for (Disciplina disciplina : disciplinas) {
			
			somaNotas += disciplina.getNotaDisciplina();
		}
		
		//Deixando o calculo da média dinâmico
		return somaNotas / disciplinas.size();
	}
	
	public String resultado() {
		
		double mediaFinal = this.calculaMedia();
		
		if (mediaFinal >= 5.0) {
			
			if (mediaFinal >= 7.0) {
				
				return StatusAluno.APROVADO;
			} else {
				
				return StatusAluno.RECUPERACAO;
			}
		}else {
			
			return StatusAluno.REPROVADO;
		}
	}
}
