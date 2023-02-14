package cursojava.executavel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;

import cursojava.classes.Aluno;
import cursojava.classes.Disciplina;
import cursojava.classes.Secretario;
import cursojava.constantes.StatusAluno;
import cursojava.classesauxiliares.Autenticacao;

public class Main {

	public static void main(String[] args) {

		String usuario = JOptionPane.showInputDialog("Digite seu usuário");
		String senha = JOptionPane.showInputDialog("Digite sua senha");
		
		//Validando o acesso do Secretario
		if (new Autenticacao(new Secretario()).autenticar(usuario, senha)) {
			
			HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();
			
			List<Aluno> alunos = new ArrayList<Aluno>();
			
			int qtdAlunos = Integer.parseInt(JOptionPane.showInputDialog("Quantos alunos serão adicionados à lista?"));
			
			for (int i=1; i<=qtdAlunos; i++) {
				
				Aluno aluno = new Aluno();
				
				String nome = JOptionPane.showInputDialog("Informe o nome do aluno " + i);
				aluno.setNome(nome);
				
				try { 
					
					String idade = JOptionPane.showInputDialog("Informe a idade do aluno " + i);
					aluno.setIdade(Integer.parseInt(idade));
					
				} catch (NumberFormatException e) {
					
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "A idade deve ser um número e não pode conter espaços!");
					
					String idade = JOptionPane.showInputDialog("Informe a idade do aluno " + i);
					aluno.setIdade(Integer.parseInt(idade));
					
				} catch (Exception e) {
					
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Ocorreu um erro ao processar a idade do aluno!");
				}
				
				String cpf = JOptionPane.showInputDialog("Informe o CPF do aluno " + i + "\nEsta informação será necessário para SUBSTITUIR ou REMOVER o aluno do sistema!");
				String rg = JOptionPane.showInputDialog("Informe o RG do aluno " + i + " \nEsta informação será necessário para SUBSTITUIR ou REMOVER o aluno do sistema!");
				String endereco = JOptionPane.showInputDialog("Informe o endereço do aluno " + i);
				String telefone = JOptionPane.showInputDialog("Informe o telefone do aluno " + i);
				String raAluno = JOptionPane.showInputDialog("Informe o RA do aluno " + i + "\nEsta informação será necessaprio para SUBSTITUIR ou  REMOVER o aluno no sistema!");
				String dataMatricula = JOptionPane.showInputDialog("Informe a data na qual o aluno " + i + " foi matriculado");
				String serieMatriculada = JOptionPane.showInputDialog("Informe a série do aluno " + i);
				
				aluno.setCpf(cpf);
				aluno.setRg(rg);
				aluno.setEndereco(endereco);
				aluno.setTelefone(telefone);
				aluno.setRaAluno(raAluno);
				aluno.setDataMatricula(dataMatricula);
				aluno.setSerieMatriculada(serieMatriculada);
				
				int qtdDisciplinas = Integer.parseInt(JOptionPane.showInputDialog("Quantas disciplinas o aluno " + i + " possui?"));
				
				for (int j=1; j<=qtdDisciplinas; j++) {
					
					Disciplina disciplina = new Disciplina();

					String nomeDisciplina = JOptionPane.showInputDialog("Informe o nome da disciplina " + j);
					disciplina.setNomeDisciplina(nomeDisciplina);
					
					try {
				
					String notaDisciplina = JOptionPane.showInputDialog("Informe a nota do aluno " + i + " na disciplina " + j);
					disciplina.setNotaDisciplina(Double.parseDouble(notaDisciplina));
					
					} catch (NumberFormatException e) {
						
						e.printStackTrace();
						
						JOptionPane.showMessageDialog(null, "A nota deve ser um número!");
						
						String notaDisciplina = JOptionPane.showInputDialog("Informe a nota do aluno " + i + " na disciplina " + j);
						disciplina.setNotaDisciplina(Double.parseDouble(notaDisciplina));
						
					} catch (Exception e) {
						
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Ocorreu um erro ao processar a nota!");
					}
					
					aluno.getDisciplinas().add(disciplina);
				}
				
				alunos.add(aluno);
			}
			
			//Substituir alunos da lista
			
			int resposta = JOptionPane.showConfirmDialog(null, "Deseja substituir algum aluno na lista?");
			
			if (resposta == 0) {
				
				int continuarSubstituir = 0;
				
				do {
					
					String cpfRgRaSubstituir = JOptionPane.showInputDialog("Informe o CPF, RG ou RA do aluno à ser dubstituído");
					
					for (int posicaoA=0; posicaoA<alunos.size(); posicaoA++) {
						
						Aluno aluno = alunos.get(posicaoA);
						
						if (cpfRgRaSubstituir.equals(aluno.getCpf()) | cpfRgRaSubstituir.equals(aluno.getRg()) | cpfRgRaSubstituir.equals(aluno.getRaAluno())) {
							
							Aluno novoAluno = new Aluno();
							
							String nome = JOptionPane.showInputDialog("Informe o nome do novo aluno");
							novoAluno.setNome(nome);
							
							try {
								
								String idade = JOptionPane.showInputDialog("Informe a idade do novo aluno");
								novoAluno.setIdade(Integer.parseInt(idade));
							
							} catch (NumberFormatException e) {
								
								e.printStackTrace();
								JOptionPane.showMessageDialog(null, "A idade deve ser um número e não pode conter espaços!");
								
								String idade = JOptionPane.showInputDialog("Informe a idade do novo aluno");
								novoAluno.setIdade(Integer.parseInt(idade));
								
							} catch (Exception e) {
								
								e.printStackTrace();
								JOptionPane.showMessageDialog(null, "Ocorreu um erro ao processar a idade do aluno!");
							}
							
							String cpf = JOptionPane.showInputDialog("Informe o CPF do novo aluno");
							String rg = JOptionPane.showInputDialog("Informe o RG do novo aluno");
							String endereco = JOptionPane.showInputDialog("Informe o endereco do novo aluno");
							String telefone = JOptionPane.showInputDialog("Informe o telefone do novo aluno");
							String raAluno = JOptionPane.showInputDialog("Informe o RA do novo aluno");
							String dataMatricula = JOptionPane.showInputDialog("Informe a data de matrícula do novo aluno");
							String serieMatriculada = JOptionPane.showInputDialog("Informe a série em que o novo aluno foi matriculado");
							
							novoAluno.setCpf(cpf);
							novoAluno.setRg(rg);
							novoAluno.setEndereco(endereco);
							novoAluno.setTelefone(telefone);
							novoAluno.setRaAluno(raAluno);
							novoAluno.setDataMatricula(dataMatricula);
							novoAluno.setSerieMatriculada(serieMatriculada);
							
							int qtdDisciplina = Integer.parseInt(JOptionPane.showInputDialog("Quantas disciplinas o novo aluno possui?"));
							
							for (int posicaoD=1; posicaoD<=qtdDisciplina; posicaoD++) {
								
								Disciplina novaDisciplina = new Disciplina();
								
								String nomeDisciplina = JOptionPane.showInputDialog("Informe o nome da disciplina " + posicaoD);
								novaDisciplina.setNomeDisciplina(nomeDisciplina);
								
								try {
									
									String notaDisciplina = JOptionPane.showInputDialog("Informe a nota do novo aluno da disciplina " + posicaoD);
									novaDisciplina.setNotaDisciplina(Double.parseDouble(notaDisciplina));
								
								} catch (NumberFormatException e) {
									
									e.printStackTrace();
									JOptionPane.showMessageDialog(null, "A nota deve ser um número!");
									
									String notaDisciplina = JOptionPane.showInputDialog("Informe a nota do novo aluno da disciplina " + posicaoD);
									novaDisciplina.setNotaDisciplina(Double.parseDouble(notaDisciplina));
									
								} catch (Exception e) {
									
									e.printStackTrace();
									JOptionPane.showMessageDialog(null, "Ocorreu um erro ao processar a nota!");
								}
								
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
					
					String cpfRgRaRemover = JOptionPane.showInputDialog("Informe o CPF, RG ou RA do aluno a ser removido");
					
					for (Aluno aluno : alunos) {
						
						if (cpfRgRaRemover.equals(aluno.getCpf()) | cpfRgRaRemover.equals(aluno.getRg()) | cpfRgRaRemover.equals(aluno.getRaAluno())) {
							
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
			
			System.out.println("----------Aluno aprovados----------");
			for (Aluno aluno : maps.get(StatusAluno.APROVADO)) {
				
				System.out.println(aluno.toString());
				System.out.println("Média >>> " + aluno.calculaMedia());
				System.out.println("\n");
			}
			
			System.out.println("----------Alunos em recuperação----------");
			for (Aluno aluno : maps.get(StatusAluno.RECUPERACAO)) {
				
				System.out.println(aluno.toString());
				System.out.println("Média >>> " + aluno.calculaMedia());
				System.out.println("\n");
			}
			
			System.out.println("----------Alunos reprovados----------");
			for (Aluno aluno : maps.get(StatusAluno.REPROVADO)) {
				
				System.out.println(aluno.toString());
				System.out.println("Média >>> " + aluno.calculaMedia());
				System.out.println("\n");
			}
			
		} else {
			
			JOptionPane.showMessageDialog(null, "Usuário ou Senha incorretos!");
		}
	}

}
