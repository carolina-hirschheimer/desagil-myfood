package br.edu.insper.desagil.myfood;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Estabelecimento {
	private String nome;
	private Map<Integer, Item> itens;

	public Estabelecimento(String nome) {
		this.nome = nome;
		this.itens = new HashMap<>();
	}

	public String getNome() {
		return this.nome;
	}

	public void cadastra(int codigo, Item item) {
		this.itens.put(codigo, item);
	}

	public double processa(List<Integer> codigos) {
		double total = 0;
		for (int codigo: codigos) {
			total += this.itens.get(codigo).getPreco();
		}
		return total;
	}
}
