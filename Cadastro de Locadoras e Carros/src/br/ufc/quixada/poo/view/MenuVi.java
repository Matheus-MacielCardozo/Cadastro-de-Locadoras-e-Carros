package br.ufc.quixada.poo.view;

import java.util.ArrayList;
import java.util.Scanner;

import br.ufc.quixada.poo.controller.GerenciaLocadoraImpl;
import br.ufc.quixada.poo.model.Locadora;
import br.ufc.quixada.poo.model.Veiculo;

public class MenuVi {

	private boolean running = true;
	private GerenciaLocadoraImpl gerencia = new GerenciaLocadoraImpl();

	private void printMenuInicial() {
		System.out.println("-------------------------");
		String menu = "Menu Locadora de Ve�culos \n" + 
		"-------------------------\n"+
		"Voc� �: \n" + 
		"1 - ADM \n" + 
		"2 - CLIENTE \n" + 
		"3 - SAIR";

		System.out.println(menu);

	}

	private void criarLocadora() {

		System.out.println("Adicionando uma locadora ");
		String nome = lerString("Digite o nome da locadora: ");
		String endereco = lerString("Digite o endere�o da locadora: ");
		int cnpj = lerInteiro("Digite o CNPJ da locadora: ");
		
		Locadora locadora = new Locadora(nome, endereco, cnpj);
		
		boolean teste = gerencia.testaLocadora(cnpj);
		
		if(teste) {
			boolean add = gerencia.adicionarLocadora(locadora);

			if (add)
				System.out.println("Locadora adiconada com sucesso!\n");
			else
				System.out.println("N�o foi poss�vel adicionar a locadora!\n");
		}else {
			System.out.println("\n-------------------------");
			System.out.println("N�o foi possivel, tente novamente com outro cnpj!\n");
			criarLocadora();
		}
		
		
	}

	private void editarLocadora() {

		System.out.println("Editando uma locadora ");
		String nome = lerString("Digite o novo nome da locadora: ");
		String endereco = lerString("Digite o novo endere�o da locadora: ");
		int cnpj = lerInteiro("Digite o CNPJ da locadora que deseja alterar as informa��es: ");

		Locadora l = new Locadora(nome, endereco, cnpj);
		boolean edit = gerencia.editarLocadora(l);

		if (edit)
			System.out.println("Locadora editada com sucesso!\n");
		else
			System.out.println("N�o foi poss�vel editar a locadora com o nome informado!\n");
	}

	private void excluirLocadora() {
		System.out.println("Excluindo uma locadora");
		int cnpj_locadora = lerInteiro("Digite o cnpj da locadora que deseja excluir: ");
		boolean exc = gerencia.apagarLocadora(cnpj_locadora);

		if(exc)
			System.out.println("Locadora exclu�da com sucesso!\n");
		else
			System.out.println("N�o foi poss�vel exlcuir a locadora com o cnpj informado! ");
	}

	private void getLocadoraNome() {
		System.out.println("Pesquisando uma locadora");
		String nome_locadora = lerString("Digite o nome da locadora que deseja pesquisar: ");

		if(nome_locadora != null)
			System.out.println(gerencia.getPesquisarLocadora(nome_locadora));
		else
			System.out.println("N�o foi poss�vel encontrar a locadora procurada! \n");
	}
	
	private void getLocadoraEnde() {
		System.out.println("Pesquisando uma locadora");
		String ende_locadora = lerString("Digite o endere�o da locadora que deseja pesquisar: ");

		if(ende_locadora != null)
			System.out.println(gerencia.getLocadoraEnde(ende_locadora));
		else
			System.out.println("N�o foi poss�vel encontrar a locadora procurada! \n");
	}

	private void adicionarVeiculo() {

		System.out.println("Adicionando um carro");
		String nome = lerString("Digite o nome do ve�culo: ");
		int cnpj_locad = lerInteiro("Digite o cnpj da locadora que deseja inserir o ve�culo: ");
		String placa = lerString("Digite placa do ve�culo: ");
		String categoria = lerString("Digite a categoria do ve�culo: ");
		int preco = lerInteiro("Digite o valor do ve�culo: ");

		Veiculo veiculo = new Veiculo(nome, categoria, placa, preco);
		
		boolean testa = gerencia.testaVeiculo(placa);
		
		if(testa) {
			boolean add = gerencia.adicionarVeiculo(veiculo, cnpj_locad);

			if (add)
				System.out.println("Ve�culo adiconado com sucesso! \n");
			else
				System.out.println("N�o foi poss�vel adicionar o carro! \n");

		}else {
			System.out.println("\n-------------------------");
			System.out.println("N�o foi possivel adicionar, placa j� existente. Tente novamente!\n");
			adicionarVeiculo();
		}
		
		
	}

	private void editarVeiculo() {

		System.out.println("Editando um carro");
		String placa = lerString("Digite a placa do ve�culo que deseja editar: ");
		String nome = lerString("Digite nome do veiculo: ");
		String categoria = lerString("Digite a categoria do veiculo: ");
		int preco = lerInteiro("Digite o valor do veiculo: ");

		Veiculo veiculo = new Veiculo(nome, categoria, placa, preco);
		boolean edit = gerencia.editarVeiculo(veiculo);

		if (edit) System.out.println("Carro editado com sucesso!\n");
		else
			System.out.println("N�o foi possivel editar o ve�culo com a placa informada! \n");
	}

	private void excluirVeiculo() {
		System.out.println("Excluindo um ve�culo");
		String placa = lerString("Digite a placa do ve�culo que deseja excluir: ");
		boolean exc = gerencia.apagarVeiculo(placa);

		if (exc)
			System.out.println("Ve�culo exclu�do com sucesso! \n");
		else
			System.out.println("N�o foi poss�vel exlcuir o ve�culo com a placa informada! \n");
	}

	private void getVeiculoNome() {
		System.out.println("Pesquisando um ve�culo");
		String nome_veiculo = lerString("Digite o nome do ve�culo que deseja pesquisar: ");

		if(nome_veiculo != null)
			System.out.println(gerencia.getVeiculoNome(nome_veiculo));
		else
			System.out.println("N�o foi poss�vel encontrar o ve�culo procurado! \n");
	}

	private void getVeiculoCategoria() {
		System.out.println("Pesquisando um ve�culo");
		String categoria_veiculo = lerString("Digite a categoria do ve�culo que deseja pesquisar: ");

		if(categoria_veiculo != null)
			System.out.println(gerencia.getVeiculoCategoria(categoria_veiculo));
		else
			System.out.println("N�o foi poss�vel encontrar o ve�culo procurado! \n");
	}

	private void avaliarOpcao(int opcao) {

		switch (opcao) {

		case 1:
			System.out.println("-------------------------");
			System.out.println("    BEM VINDO ADM");
			System.out.println("-------------------------");
			String menu_adm = "Selecione a op��o desejada: \n" + 
					"1 - Criar Locadora \n" +
					"2 - Editar Locadora \n" +
					"3 - Excluir Locadora \n" +
					"4 - Demais op��es de Locadora \n";

			System.out.println(menu_adm);
			String msg_adm = "Digite a opcao desejada: ";
			int opcao_adm = lerInteiro(msg_adm);
			avaliarOpcaoAdm(opcao_adm);
			break;

		case 2:
			System.out.println("\n");
			System.out.println("-------------------------");
			System.out.println("   BEM VINDO CLIENTE ");
			System.out.println("-------------------------");
			String menu_cliente = "Selecione a op��o desejada: \n" + 
					"1 - Locadoras Dispon�veis \n" +
					"2 - Pesquisar Locadora pelo nome: \n" +
					"3 - Pesquisar Locadora pelo endere�o: \n" +
					"4 - Pesquisar Ve�culo pelo nome: \n" + 
					"5 - Pesquisar Ve�culo pela categoria: \n";

			System.out.println(menu_cliente);
			String msg_cliente = "Digite a opcao desejada: ";
			int opcao_cliente = lerInteiro(msg_cliente);
			avaliarOpcaoCliente(opcao_cliente);
			break;

		case 3:
			System.out.println("Obrigado, volte sempre!");
			this.running = false;
			break;

		default:
			throw new IllegalArgumentException("Unexpected value: " + opcao);
		}
	}

	private void avaliarOpcaoAdm(int opcao_adm) {

		switch (opcao_adm) {

		case 1:
			criarLocadora();
			break;

		case 2:
			editarLocadora();
			break;

		case 3:
			excluirLocadora();
			break;

		case 4:
			System.out.println("\n");
			System.out.println("-------------------------");
			String menu_aux_adm = "Selecione a op��o desejada: \n" + 
			"1 - Locadoras Dispon�veis \n" + 
			"2 - Adicionar Ve�culo \n" + 
			"3 - Editar Ve�culo \n" + 
			"4 - Excluir Ve�culo \n";

			System.out.println(menu_aux_adm);
			String msg_aux = "Digite a opcao desejada: ";
			int opcao_aux = lerInteiro(msg_aux);
			avaliarOpcaoAux(opcao_aux);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + opcao_adm);
		}
	}

	private void avaliarOpcaoCliente(int opcao_cliente) {

		switch (opcao_cliente) {

		case 1:
			gerencia.printLocadoras();
			break;

		case 2:
			getLocadoraNome();
			break;
			
		case 3:
			getLocadoraEnde();
			break;
			
		case 4:
			getVeiculoNome();
			break;
			
		case 5:
			getVeiculoCategoria();
			break;
			
		default:
			throw new IllegalArgumentException("Unexpected value: " + opcao_cliente);
		}
	}

	private void avaliarOpcaoAux(int opcao_aux) {

		switch (opcao_aux) {

		case 1:
			gerencia.printLocadoras();
			break;
		case 2:
			adicionarVeiculo();
			break;

		case 3:
			editarVeiculo();
			break;

		case 4:
			excluirVeiculo();
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + opcao_aux);
		}
	}

	private int lerInteiro(String mensagem) {

		int numeroLido = 0;

		System.out.println(mensagem);
		Scanner scanner = new Scanner(System.in);
		numeroLido = scanner.nextInt();

		return numeroLido;

	}

	private String lerString(String mensagem) {

		System.out.println(mensagem);

		String msg;
		Scanner scanner = new Scanner(System.in);
		msg = scanner.nextLine();

		return msg;
	}

	public void run() {


		while (running) {

			printMenuInicial();
			String msg = "Digite a opcao desejada: ";
			int opcao = lerInteiro(msg);
			avaliarOpcao(opcao);
		}
	}
}
