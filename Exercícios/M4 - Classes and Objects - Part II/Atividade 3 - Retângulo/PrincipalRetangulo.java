/*
Academia Java - Accenture
M4 - Classes and Objects - Part II
Atividade 3 - Retângulo
Autor: Kaio Vinícius Cordeiro Batista
Instituição na qual é vinculado: UEPB - Campus VII - Patos/PB
Data: 25/07/2024
*/

package sef.module4.activity;

import javax.swing.JOptionPane;

public class PrincipalRetangulo {

	public static void main(String[] args) {
		String primeiroLado, segundoLado;
		double lado1, lado2;

		Retangulo novoRetangulo = new Retangulo();
		novoRetangulo.setLado1(10);
		novoRetangulo.setLado2(5);
		novoRetangulo.calcularArea();
		novoRetangulo.calcularPerimetro();

		novoRetangulo.setLado2(7);
		novoRetangulo.calcularArea();
		novoRetangulo.calcularPerimetro();

		Retangulo[] retangulos = new Retangulo[5];
		for (int i = 0; i < 5; i++) {
			JOptionPane.showMessageDialog(null, "Agora, insira as informações do retângulo " + (i + 1) + ":",
					"RETÂNGULO " + (i + 1), JOptionPane.WARNING_MESSAGE);
			primeiroLado = JOptionPane.showInputDialog("Lado 1:");
			segundoLado = JOptionPane.showInputDialog("Lado 2:");
			lado1 = Double.parseDouble(primeiroLado);
			lado2 = Double.parseDouble(segundoLado);
			retangulos[i] = new Retangulo(lado1, lado2);
			retangulos[i].calcularArea();
			retangulos[i].calcularPerimetro();
		}
	}

}
