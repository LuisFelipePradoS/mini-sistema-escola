package cursojava.classes;

public abstract class Pessoa {

	protected String nome;
	protected int idade;
	protected String cpf;
	protected String rg;
	protected String telefone;
	protected String endereco;
	
	public final String getNome() {
		return nome;
	}
	public final void setNome(String nome) {
		this.nome = nome;
	}
	public final int getIdade() {
		return idade;
	}
	public final void setIdade(int idade) {
		this.idade = idade;
	}
	public final String getCpf() {
		return cpf;
	}
	public final void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public final String getRg() {
		return rg;
	}
	public final void setRg(String rg) {
		this.rg = rg;
	}
	public final String getTelefone() {
		return telefone;
	}
	public final void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public final String getEndereco() {
		return endereco;
	}
	public final void setEndereco(String endereco) {
		this.endereco = endereco;
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
		Pessoa other = (Pessoa) obj;
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
	
	public abstract String toString(); 
	
}
