package cursojava.classesauxiliares;

import cursojava.interfaces.PermitirAcesso;

/*Esta classe recebe apenas outras classes que
 * implementam a interface de acesso*/
public class Autenticacao {
	
	private PermitirAcesso permitirAcesso;
	
	public Autenticacao(PermitirAcesso permitirAcesso) {
		this.permitirAcesso = permitirAcesso;
	}
	
	public boolean autenticar(String usuario, String senha) {
		return permitirAcesso.autenticar(usuario, senha);
	}

}
