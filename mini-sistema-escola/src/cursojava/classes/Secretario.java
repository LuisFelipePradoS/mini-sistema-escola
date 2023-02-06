package cursojava.classes;

import cursojava.interfaces.PermitirAcesso;

public class Secretario extends Pessoa implements PermitirAcesso {
	
	private String nivelExperiencia;
	private String tempoExperiencia;
	private String cargaHoraria;
	
	public final String getNivelExperiencia() {
		return nivelExperiencia;
	}
	public final void setNivelExperiencia(String nivelExperiencia) {
		this.nivelExperiencia = nivelExperiencia;
	}
	public final String getTempoExperiencia() {
		return tempoExperiencia;
	}
	public final void setTempoExperiencia(String tempoExperiencia) {
		this.tempoExperiencia = tempoExperiencia;
	}
	public final String getCargaHoraria() {
		return cargaHoraria;
	}
	public final void setCargaHoraria(String cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	@Override
	public String toString() {
		return "Secretario [nivelExperiencia=" + nivelExperiencia + ", tempoExperiencia=" + tempoExperiencia
				+ ", cargaHoraria=" + cargaHoraria + ", nome=" + nome + ", idade=" + idade + ", cpf=" + cpf + ", rg="
				+ rg + ", telefone=" + telefone + ", endereco=" + endereco + "]";
	}

	@Override
	public boolean autenticar(String usuario, String senha) {
		return usuario.equals("admin") && senha.equals("admin");
	}
	
}
