package cursojava.classes;

public class Disciplina {

	private String nomeDisciplina;
	private double notaDisciplina;
	
	public final String getNomeDisciplina() {
		return nomeDisciplina;
	}
	public final void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	public final double getNotaDisciplina() {
		return notaDisciplina;
	}
	public final void setNotaDisciplina(double notaDisciplina) {
		this.notaDisciplina = notaDisciplina;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeDisciplina == null) ? 0 : nomeDisciplina.hashCode());
		long temp;
		temp = Double.doubleToLongBits(notaDisciplina);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		if (Double.doubleToLongBits(notaDisciplina) != Double.doubleToLongBits(other.notaDisciplina))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Disciplina [nomeDisciplina=" + nomeDisciplina + ", notaDisciplina=" + notaDisciplina + "]";
	}

}
