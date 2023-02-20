package cursojava.classes;

import java.util.Arrays;

public class Disciplina {

	private String nomeDisciplina;
	private double[] notasDisciplina = new double[4];
	
	public String getNomeDisciplina() {
		return nomeDisciplina;
	}
	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	public double[] getNotasDisciplina() {
		return notasDisciplina;
	}
	public void setNotasDisciplina(double[] notasDisciplina) {
		this.notasDisciplina = notasDisciplina;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeDisciplina == null) ? 0 : nomeDisciplina.hashCode());
		result = prime * result + Arrays.hashCode(notasDisciplina);
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
		Disciplina other = (Disciplina) obj;
		if (nomeDisciplina == null) {
			if (other.nomeDisciplina != null)
				return false;
		} else if (!nomeDisciplina.equals(other.nomeDisciplina))
			return false;
		if (!Arrays.equals(notasDisciplina, other.notasDisciplina))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Disciplina [nomeDisciplina=" + nomeDisciplina + ", notasDisciplina=" + Arrays.toString(notasDisciplina)
				+ "]";
	}
	
	public double calculaMediaDisciplina() {
		
		double somaNotas = 0.0;
		
		for (int i=0; i<notasDisciplina.length; i++) {
			
			somaNotas += notasDisciplina[i];
		}
		
		return somaNotas / 4;
	}
}
