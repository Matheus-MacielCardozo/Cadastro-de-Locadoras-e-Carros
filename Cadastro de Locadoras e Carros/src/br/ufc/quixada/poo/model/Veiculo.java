package br.ufc.quixada.poo.model;

public class Veiculo {
	
	private String nome;
	private String categoria;
	private String placa;
	private double preco;
	
	public Veiculo(String nome, String categoria, String placa, double preco) {
		super();
		this.nome = nome;
		this.categoria = categoria;
		this.placa= placa;
		this.preco= preco;
	}
	
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	@Override
	public String toString() {
		return "Veiculo \n" + "--------------\n" + "Nome: \n" + nome + "\nCategoria: \n" + categoria + "\nPlaca: \n" + placa + "\nPreco: \n" + preco;
	}
	
	
	
}
