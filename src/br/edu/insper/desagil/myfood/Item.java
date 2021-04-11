package br.edu.insper.desagil.myfood;

public abstract class Item {
	private String nome;

	protected Item(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public abstract double getPreco();
}
