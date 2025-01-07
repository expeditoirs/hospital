package main;
import java.util.Scanner;
import pacientesAtendidos.Atendidos;
import pacientesFila.Paciente;
import estoque.Estoque;
import menus.Menu;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			Menu.principal();
			int opcao = scanner.nextInt();
			scanner.nextLine();
			switch (opcao) {
				case 1-> Paciente.adicionarPaciente();
				case 2-> Paciente.atenderPaciente();
				case 3-> Paciente.mostrarFila();
				case 4-> Atendidos.mostrarAtendidosHoje();
				case 5-> Estoque.adicionarMedicamentosAoEstoque();
				case 6-> Estoque.entregarMedicamento();
				case 7-> Estoque.mostrarEstoque();
				case 8-> {
					System.out.println("Encerrando!");
					scanner.close();
					return;
				}
				default -> System.out.println("Opção inválida!") ;
			}
		}
	}
}
