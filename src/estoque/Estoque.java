package estoque;

import java.util.ArrayList;
import java.util.Scanner;

public class Estoque {
	private String nome;
	private int quantidade;
	
	private static ArrayList<Estoque> medicamentos = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);

	
	public Estoque(String nome, int quantidade) {
		this.nome = nome;
		this.quantidade = quantidade;
	}
	private String getNome() {
		return nome;
	}
	public void adicionarQuantidade(int quantidade) {
	    this.quantidade += quantidade;
	}
	public static Estoque isMedicamento(String nome) {
		return medicamentos.stream()
				.filter(c->c.getNome().equals(nome))
				.findFirst()
				.orElse(null);
		
	}
	public static void adicionarMedicamentosAoEstoque() {
		System.out.print("Digite o nome do medicamento: ");
		String nome = scanner.nextLine();
		System.out.print("Digite a qtd do medicamento: ");
		int quantidade = scanner.nextInt();
		scanner.nextLine();
		
		Estoque medicamentoExistente = isMedicamento(nome);

        if (medicamentoExistente != null) {
            // Se já existir, adiciona a quantidade ao medicamento
            medicamentoExistente.adicionarQuantidade(quantidade);
            System.out.println("Quantidade adicionada ao medicamento existente: " + nome);
        } else {
            // Se não existir, cria um novo medicamento e adiciona ao estoque
            Estoque novoMedicamento = new Estoque(nome, quantidade);
            medicamentos.add(novoMedicamento);
            System.out.println("Novo medicamento adicionado ao estoque: " + nome);
        }
	}
	
	public static void entregarMedicamento() {
		System.out.print("Digite o nome do medicamento: ");
		String nome = scanner.nextLine();
		System.out.print("Digite a qtd do medicamento: ");
		int quantidade = scanner.nextInt();
		scanner.nextLine();
		
		Estoque medicamentoExistente = isMedicamento(nome);

        if (medicamentoExistente != null) {
            medicamentoExistente.adicionarQuantidade(-quantidade);
            System.out.println("Quantidade entregada: " + nome);
        } else {
            System.out.println("Esse nome não existe no estoque");
        }
	}
	public static void mostrarEstoque() {
        if (medicamentos.isEmpty()) {
            System.out.println("Estoque vazio.");
        } else {
            System.out.println("Estoque:");
            for (Estoque med : medicamentos) {
                System.out.println("Nome: " + med.getNome() + ", Quantidade: " + med.quantidade);
            }
        }
    }

}
