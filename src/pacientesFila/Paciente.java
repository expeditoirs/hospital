package pacientesFila;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import pacientesAtendidos.Atendidos;

public class Paciente {
	private String nome;
	private String idade;
	private String cpf;
	private LocalDate data;
	
	private static ArrayList<Paciente> pacientes = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);

	public Paciente(String nome, String idade, String cpf, LocalDate data) {
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.data = data;
	}
	@Override
	public String toString() {
		return "Paciente [nome=" + nome + ", idade=" + idade + ", cpf=" + cpf + ", data=" + data + "]";
	}
	public static void adicionarPaciente() {
		System.out.print("Insira o nome: ");
		String nome = scanner.nextLine();
		System.out.print("Insira a idade: ");
		String idade = scanner.nextLine();
		System.out.print("Insira o CPF: ");
		String cpf = scanner.nextLine();
		
		Paciente novoPaciente = new Paciente(nome, idade, cpf, LocalDate.now());
		pacientes.add(novoPaciente);
		System.out.print("Paciente Adicionado!");
		
	}
	public static void atenderPaciente() {
		if (pacientes.isEmpty()) {
	        System.out.println("Nenhum paciente na fila para atender.");
	        return;
	    }
	    // Pega o primeiro paciente
	    Paciente pacienteAtendido = pacientes.get(0);
	    pacientes.remove(0);

	    Atendidos.adicionarAtendido(pacienteAtendido.nome, 
                pacienteAtendido.idade, 
                pacienteAtendido.cpf, 
                pacienteAtendido.data);
	    System.out.println("Paciente atendido e removido da fila: " + pacienteAtendido);
		
		
	}
	
	public static void mostrarFila() {
		if (pacientes.isEmpty()) {
			System.out.println("Nenhum carro");
		}else {
			System.out.println("Lista:");
			for (Paciente paciente: pacientes) {
				System.out.println(paciente);
			}
		}
	}
}
