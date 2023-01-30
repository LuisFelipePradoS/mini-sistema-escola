package cursojava.executavel;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

import cursojava.classes.*;
import cursojava.constantes.StatusAluno;

public class Main {

	public static void main(String[] args) {

		String user = JOptionPane.showInputDialog("Digite seu usuário");
		String password = JOptionPane.showInputDialog("Digite sua senha");
		
		if (user.equals("admin") && password.equals("admin")) {
			
			HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();
			
			List<Aluno> alunos = new ArrayList<Aluno>();
			
			int qtdAlunos = Integer.parseInt(JOptionPane.showInputDialog("Quantos alunos serão adicionados à lista?"));
			
			for (int i=1; i<=qtdAlunos; i++) {
				
				String nome = JOptionPane.showInputDialog("Informe o nome do aluno " + i);
				String idade = JOptionPane.showInputDialog("Informe a idade do aluno " + i);
				String cpf = JOptionPane.showInputDialog("Informe o CPF do aluno " + i);
				String rg = JOptionPane.showInputDialog("Informe o RG do aluno " + i);
				String endereco = JOptionPane.showInputDialog("Informe o endereço do aluno " + i);
				String telefone = JOptionPane.showInputDialog("Informe o telefone do aluno " + i);
				
				Aluno aluno = new Aluno();
				
				aluno.setNome(nome);
				aluno.setIdade(Integer.parseInt(idade));
				aluno.setCpf(cpf);
				aluno.setRg(rg);
				aluno.setEndereco(endereco);
				aluno.setTelefone(telefone);
				
				int qtdDisciplinas = Integer.parseInt(JOptionPane.showInputDialog("Quantas disciplinas o aluno " + i + " possui?"));
				
				for (int j=1; j<=qtdDisciplinas; j++) {
					
					String nomeDisciplina = JOptionPane.showInputDialog("Informe o nome da disciplina " + j);
					String notaDisciplina = JOptionPane.showInputDialog("Informe a nota do aluno " + i + " na disciplina " + j);
					
					Disciplina disciplina = new Disciplina();
					
					disciplina.setNomeDisciplina(nomeDisciplina);
					disciplina.setNotaDisciplina(Double.parseDouble(notaDisciplina));
					
					aluno.getDisciplinas().add(disciplina);
				}
				
				alunos.add(aluno);
			}
		} else {
			
			JOptionPane.showMessageDialog(null, "Usuário ou Senha incorretos!");
		}
	}

}
