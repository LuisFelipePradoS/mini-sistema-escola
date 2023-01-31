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
			
			//Substituir alunos da lista
			
			int resposta = JOptionPane.showConfirmDialog(null, "Deseja substituir algum aluno na lista?");
			
			if (resposta == 0) {
				
				int continuarSubstituir = 0;
				
				do {
					
					String cpfRgSubstituir = JOptionPane.showInputDialog("Informe o CPF ou RG do aluno à ser dubstituído");
					
					for (int posicaoA=0; posicaoA<alunos.size(); posicaoA++) {
						
						Aluno aluno = alunos.get(posicaoA);
						
						if (cpfRgSubstituir.equals(aluno.getCpf()) | cpfRgSubstituir.equals(aluno.getRg())) {
							
							String nome = JOptionPane.showInputDialog("Informe o nome do novo aluno");
							String idade = JOptionPane.showInputDialog("Informe a idade do novo aluno");
							String cpf = JOptionPane.showInputDialog("Informe o CPF do novo aluno");
							String rg = JOptionPane.showInputDialog("Informe o RG do novo aluno");
							String endereco = JOptionPane.showInputDialog("Informe o endereco do novo aluno");
							String telefone = JOptionPane.showInputDialog("Informe o telefone do novo aluno");
							
							Aluno novoAluno = new Aluno();
							
							novoAluno.setNome(nome);
							novoAluno.setIdade(Integer.parseInt(idade));
							novoAluno.setCpf(cpf);
							novoAluno.setRg(rg);
							novoAluno.setEndereco(endereco);
							novoAluno.setTelefone(telefone);
							
							int qtdDisciplina = Integer.parseInt(JOptionPane.showInputDialog("Quantas disciplinas o novo aluno possui?"));
							
							for (int posicaoD=1; posicaoD<=qtdDisciplina; posicaoD++) {
								
								String nomeDisciplina = JOptionPane.showInputDialog("Informe o nome da disciplina " + posicaoD);
								String notaDisciplina = JOptionPane.showInputDialog("Informe a nota do novo aluno da disciplina " + posicaoD);
								
								Disciplina novaDisciplina = new Disciplina();
								
								novaDisciplina.setNomeDisciplina(nomeDisciplina);
								novaDisciplina.setNotaDisciplina(Double.parseDouble(notaDisciplina));
								
								novoAluno.getDisciplinas().add(novaDisciplina);
							}
							
							alunos.set(posicaoA, novoAluno);
							aluno = alunos.get(posicaoA);
							
							break;
						}
					}
					
					continuarSubstituir = JOptionPane.showConfirmDialog(null, "Deseja substituir outro aluno?");
					
				} while (continuarSubstituir == 0);
			}
			
			//Remover alunos da lista
			
			resposta = JOptionPane.showConfirmDialog(null, "Deseja remover algum aluno da lista?");
			
			if (resposta == 0) {
				
				int continuarRemover = 0;
				
				do {
					
					String cpfRgRemover = JOptionPane.showInputDialog("Informe o CPF ou RG do aluno a ser removido");
					
					for (Aluno aluno : alunos) {
						
						if (cpfRgRemover.equals(aluno.getCpf()) | cpfRgRemover.equals(aluno.getRg())) {
							
							alunos.remove(aluno);
							
							break;
						}
					}
					
					continuarRemover = JOptionPane.showConfirmDialog(null, "Deseja remover outro aluno da lista?");
					
				} while (continuarRemover == 0);
			}
			
			//Separando alunos em listas
			maps.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
			maps.put(StatusAluno.RECUPERACAO, new ArrayList<Aluno>());
			maps.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());
			
			for (Aluno aluno : alunos) {
				
				if (aluno.resultado().equals(StatusAluno.APROVADO)) {
					
					maps.get(StatusAluno.APROVADO).add(aluno);
				} else if (aluno.resultado().equals(StatusAluno.RECUPERACAO)) {
					
					maps.get(StatusAluno.RECUPERACAO).add(aluno);
				} else {
					
					maps.get(StatusAluno.REPROVADO).add(aluno);
				}
			}
			
		} else {
			
			JOptionPane.showMessageDialog(null, "Usuário ou Senha incorretos!");
		}
	}

}
