package br.edu.insper.desagil.myfood;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EstabelecimentoTest {
	private static double DELTA = 0.01;

	private Estabelecimento e;
	private List<Integer> codigos;

	@BeforeEach
	public void setUp() {
		e = new Estabelecimento("McDonald's");
		codigos = new ArrayList<>();
	}

	@Test
	public void doisDeTresComuns() {
		e.cadastra(1, new ItemComum("Coca-Cola", 1.25));
		e.cadastra(2, new ItemComum("Fritas", 2.50));
		e.cadastra(3, new ItemComum("Big Mac", 3.75));

		codigos.add(2);
		codigos.add(3);
		assertEquals(6.25, e.processa(codigos), DELTA);
	}

	@Test
	public void doisComunsUmCombo() {
		List<ItemComum> itens = new ArrayList<>();
		itens.add(new ItemComum("Coca-Cola", 1.25));
		itens.add(new ItemComum("Fritas", 2.50));
		itens.add(new ItemComum("Big Mac", 3.75));

		e.cadastra(1, new ItemComum("Sundae", 2.25));
		e.cadastra(2, new ItemComum("Nuggets", 4.50));
		e.cadastra(3, new ItemCombo("Combo Big Mac", 0.9, itens));

		codigos.add(1);
		codigos.add(2);
		codigos.add(3);
		assertEquals(13.5, e.processa(codigos), DELTA);
	}

	@Test
	public void umComumDoisCombos() {
		List<ItemComum> itens1 = new ArrayList<>();
		itens1.add(new ItemComum("Coca-Cola", 1.25));
		itens1.add(new ItemComum("Fritas", 2.50));
		itens1.add(new ItemComum("Big Mac", 3.75));

		List<ItemComum> itens2 = new ArrayList<>();
		itens2.add(new ItemComum("Guarana", 1.00));
		itens2.add(new ItemComum("Nuggets", 4.50));
		itens2.add(new ItemComum("McChicken", 2.75));

		e.cadastra(1, new ItemComum("Sundae", 2.25));
		e.cadastra(2, new ItemCombo("Combo Big Mac", 0.9, itens1));
		e.cadastra(3, new ItemCombo("Combo McChicken", 0.8, itens2));

		codigos.add(1);
		codigos.add(2);
		codigos.add(3);
		assertEquals(15.6, e.processa(codigos), DELTA);
	}
}
