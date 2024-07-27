package br.ufc.quixada.poo.controller;

import java.util.ArrayList;

import br.ufc.quixada.poo.model.Locadora;
import br.ufc.quixada.poo.model.Veiculo;

public class GerenciaLocadoraImpl implements GerenciaLocadora {

	private ArrayList<Locadora> listaLocad;

	public GerenciaLocadoraImpl() {
		this.listaLocad = new ArrayList<Locadora>();
	}

	public boolean adicionarLocadora(Locadora locadora) {
		this.listaLocad.add(locadora);
		return true;
	}

	public boolean adicionarVeiculo(Veiculo veiculo, int cnpj) {
		boolean confirma;
		if(getExisteLocadora(cnpj) == true) {
			getLocadora(cnpj).adicionarVeiculo(veiculo);
			confirma = true;
		}
		else {
			confirma = false;
		}

		return confirma;

	}

	public void printLocadoras() {
		for(Locadora l : listaLocad) {
			System.out.println(l);
		}
	}

	public boolean apagarLocadora(int cnpj) {

		Locadora locadoraProcurando = getLocadora(cnpj);
		boolean apaguei = false;

		if (locadoraProcurando != null) {
			this.listaLocad.remove(locadoraProcurando);
			apaguei = true;
		}

		return apaguei;
	}

	public boolean editarLocadora(Locadora locadora) {

		Locadora locadoraEditar = getLocadora(locadora.getCnpj());
		boolean editei = false;

		if (locadoraEditar != null) {

			locadoraEditar.setNome(locadora.getNome());
			locadoraEditar.setEnde(locadora.getEnde());
			System.out.println(locadoraEditar);
			editei = true;

		}

		return editei;
	}

	public boolean testaLocadora(int cnpj) {
		boolean pesquisaLocadora = getTestaLocadora(cnpj);
		
		return pesquisaLocadora;
	}
	
	public boolean testaVeiculo(String placa) {
		boolean testaV = getTestaVeiculo(placa);
		
		return testaV;
	}
	
	public boolean getTestaVeiculo(String placa) {
		boolean veiculoExiste = true;
		
		for(Locadora l : listaLocad) {
			for(Veiculo v : l.getFrota()) {
				String veiculoPlaca = v.getPlaca();
				if(placa.equals( veiculoPlaca )) {
					veiculoExiste = false;
					break;
				}
			}
		}
		
		
		return veiculoExiste;
	}
	
	public boolean getTestaLocadora(int cnpj) {
		boolean locadoraExiste = true;

		for (Locadora l : listaLocad) {

			int cnpjLocadora = l.getCnpj();
			if (cnpj == cnpjLocadora) {
				locadoraExiste = false;
				break;
			}

		}

		return locadoraExiste;

	}
	
	public Locadora getLocadora(int cnpj) {
		Locadora locadoraProcurando = null;

		for (Locadora l : listaLocad) {

			int cnpjLocadora = l.getCnpj();
			if (cnpj == cnpjLocadora) {
				locadoraProcurando = l;
				break;
			}

		}

		return locadoraProcurando;
	}

	public Locadora getPesquisarLocadora(String nome) {
		Locadora locadoraProcurando = null;

		for (Locadora l : listaLocad) {
			String nomeLocadora = l.getNome();
			if (nome.equals(nomeLocadora)) {
				locadoraProcurando = l;
				break;
			}

		}

		return locadoraProcurando;
	}

	public boolean getExisteLocadora(int cnpj) {
		boolean locadoraExiste = false;

		for (Locadora l : listaLocad) {

			int cnpjLocadora = l.getCnpj();
			if (cnpj == cnpjLocadora) {
				locadoraExiste = true;
				break;
			}

		}

		return locadoraExiste;

	}
	public Locadora getLocadoraNome(String nome) {

		Locadora locadoraProcurando = null;

		for( Locadora l : listaLocad ) {
			String nomeLocadora = l.getNome();
			if( nome.equals( nomeLocadora ) ) {
				locadoraProcurando = l;
				break;
			}

		}

		return locadoraProcurando;
	}
	
	public Locadora getLocadoraEnde(String ende) {

		Locadora locadoraProcurando = null;

		for( Locadora l : listaLocad ) {
			String endeLocadora = l.getEnde();
			if( ende.equals( endeLocadora ) ) {
				locadoraProcurando = l;
				break;
			}

		}

		return locadoraProcurando;
	}

	public Veiculo getVeiculo( String placa ) {

		Veiculo veiculoProcurando = null;

		for(Locadora l : listaLocad) {
			for( Veiculo v : l.getFrota() ) {

				String placaVeiculo = v.getPlaca();
				if( placa.equals( placaVeiculo ) ) {
					veiculoProcurando = v;
					break;
				}
			}
		}

		return veiculoProcurando;
	}


	public String getVeiculoNome(String nome) {

		String veiculoProcurando = null;

		for(Locadora l : listaLocad) {
			for( Veiculo v : l.getFrota() ) {
				String nomeVeiculo = v.getNome();
				if( nome.equals( nomeVeiculo ) ) {
					return v + " " + l.toStringAux();
				}
			}
		}

		return veiculoProcurando;
	}
	
	public String getVeiculoCategoria(String categoria) {

		String veiculoProcurando = null;

		for(Locadora l : listaLocad) {
			for( Veiculo v : l.getFrota() ) {
				String categoriaVeiculo = v.getCategoria();
				if( categoria.equals( categoriaVeiculo ) ) {
					return v + " " + l.toStringAux();
				}
			}
		}
		return veiculoProcurando;
	}

	public boolean editarVeiculo(Veiculo veiculo) {

		Veiculo veiculoEditar = getVeiculo(veiculo.getPlaca());
		boolean editei = false;
		
		if(veiculoEditar != null) {
			for(Locadora l : listaLocad) {
				for(Veiculo v : l.getFrota()) {
					v.setNome(veiculo.getNome());
					v.setCategoria(veiculo.getCategoria());
					v.setPreco(veiculo.getPreco());
					System.out.println(v);
					editei = true;
					return editei;
				}
			}
		}
		return editei;
	}

	public boolean apagarVeiculo(String placa) {

		Veiculo veiculoProcurando = getVeiculo(placa);
		boolean apaguei = false;

		if(veiculoProcurando != null) {
			for(Locadora l : listaLocad)
				l.getFrota().remove(veiculoProcurando);
			apaguei = true;
			return apaguei;
		} 

		return apaguei;
	}

	
}
