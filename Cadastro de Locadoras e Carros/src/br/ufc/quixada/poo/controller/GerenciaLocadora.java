package br.ufc.quixada.poo.controller;

import java.util.ArrayList;

import br.ufc.quixada.poo.model.Locadora;

public interface GerenciaLocadora {
	
	public boolean adicionarLocadora(Locadora locadora);
	
	
	//Retorna a locadora baseado no cnpj recebido como parametro
	public Locadora getLocadora(int cnpj);
	
	public Locadora getPesquisarLocadora(String nome);
	
	//Apaga a locadora de acordo com a placa
	public boolean apagarLocadora(int cnpj);
	
	//Editar a locadora encontrada
	public boolean editarLocadora(Locadora locadora);
	
	public void printLocadoras();

}
