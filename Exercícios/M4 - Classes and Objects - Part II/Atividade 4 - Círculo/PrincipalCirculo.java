/*
Academia Java - Accenture
M4 - Classes and Objects - Part II
Atividade 4 - Círculo
Autor: Kaio Vinícius Cordeiro Batista
Instituição na qual é vinculado: UEPB - Campus VII - Patos/PB
Data: 25/07/2024
*/

package sef.module4.activity;

import javax.swing.JOptionPane;

public class PrincipalCirculo {

	public static void main(String[] args) {
		String raioDoCirculo;
		double raio;

		Circulo novoCirculo = new Circulo();
		novoCirculo.setRaio(10);
		novoCirculo.calcularArea();
		novoCirculo.calcularPerimetro();

		novoCirculo.setRaio(4);
		novoCirculo.calcularArea();
		novoCirculo.calcularPerimetro();

		Circulo[] circulos = new Circulo[5];
		for (int i = 0; i < 5; i++) {
			JOptionPane.showMessageDialog(null, "Agora, insira as informações do círculo " + (i + 1) + ":",
					"CÍRCULO " + (i + 1), JOptionPane.WARNING_MESSAGE);
			raioDoCirculo = JOptionPane.showInputDialog("Raio:");
			raio = Double.parseDouble(raioDoCirculo);
			circulos[i] = new Circulo(raio);
			circulos[i].calcularArea();
			circulos[i].calcularPerimetro();
		}
	}

}