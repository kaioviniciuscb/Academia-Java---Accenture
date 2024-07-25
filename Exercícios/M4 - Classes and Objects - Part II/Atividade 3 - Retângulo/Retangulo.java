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

public class Retangulo {
	private double lado1;
	private double lado2;
	private double area;
	private double perimetro;

	public Retangulo() {
	}

	public Retangulo(double lado1, double lado2) {
		this.lado1 = lado1;
		this.lado2 = lado2;
	}

	public void calcularArea() {
		area = lado1 * lado2;
		JOptionPane.showMessageDialog(null,
				"O valor da área do retângulo de lados " + lado1 + " e " + lado2 + " é " + area + ".",
				"Área do Retângulo", JOptionPane.INFORMATION_MESSAGE);
	}

	public void calcularPerimetro() {
		perimetro = 2 * lado1 + 2 * lado2;
		JOptionPane.showMessageDialog(null,
				"O valor do perímetro do retângulo de lados " + lado1 + " e " + lado2 + " é " + perimetro + ".",
				"Perímetro do Retângulo", JOptionPane.INFORMATION_MESSAGE);
	}

	public double getLado1() {
		return lado1;
	}

	public void setLado1(double lado1) {
		this.lado1 = lado1;
	}

	public double getLado2() {
		return lado2;
	}

	public void setLado2(double lado2) {
		this.lado2 = lado2;
	}
}
