package pacientesAtendidos;

import java.time.LocalDate;
import java.util.ArrayList;


public class Atendidos {
	private String nome;
	private String idade;
	private String cpf;
	private LocalDate data;
	
	private static ArrayList<Atendidos> atendidos = new ArrayList<>();

	public Atendidos(String nome, String idade, String cpf, LocalDate data) {
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.data = data;
	}
	public static void adicionarAtendido(String nome, String idade, String cpf, LocalDate data) {
		Atendidos novoAtendimento = new Atendidos(nome, idade, cpf, LocalDate.now());
		atendidos.add(novoAtendimento);
	}
	public static void mostrarAtendidosHoje() {
		if (atendidos.isEmpty()) {
			System.out.println("Nenhum paciente atendido");
		}else {
			System.out.println("Pacientes atendidos hoje: ");
			for( Atendidos atendidos: atendidos) {
				System.out.println(atendidos);
			}
		}
	}
	@Override
	public String toString() {
		return "Atendidos [nome=" + nome + ", idade=" + idade + ", cpf=" + cpf + ", data=" + data + "]";
	}
	

}
