package cursojava.executavel;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

import cursojava.classes.*;
import cursojava.constantes.StatusAluno;

public class Main {

	public static void main(String[] args) {

		String user = JOptionPane.showInputDialog("Digite seu usu�rio");
		String password = JOptionPane.showInputDialog("Digite sua senha");
		
		if (user.equals("admin") && password.equals("admin")) {
			
			//C�digos das rotinas
			
		} else {
			
			JOptionPane.showMessageDialog(null, "Usu�rio ou Senha incorretos!");
		}
	}

}
