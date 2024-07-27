package br.ufc.quixada.poo.model;

import java.util.ArrayList;

public class Locadora {


	private String nome;
	private String endereco;
	private int cnpj;

	private ArrayList<Veiculo> frota = new ArrayList<Veiculo>();


	public boolean adicionarVeiculo(Veiculo veiculo) {
		this.frota.add(veiculo);	
		return true;
	}

	public ArrayList<Veiculo> listarVeiculos() {
		return frota;
	}
	
	public Locadora(String nome, String endereco, int cnpj) {
		this.nome = nome;
		this.endereco = endereco;
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEnde() {
		return endereco;
	}

	public void setEnde(String local) {
		this.endereco = local;
	}

	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}

	public ArrayList<Veiculo> getFrota(){
		return frota;
	}

	@Override
	public String toString() {
		return "\nLocadora\n" + "Nome: \n" + nome + "\nEndereço: \n" + endereco + " " + "\n\nFrota \n" + frota;
	}
	public String toStringAux() {
		return "\nLocadora \n" + "Nome: \n" + nome + "\n Endereço: \n" + endereco;
	}
}
