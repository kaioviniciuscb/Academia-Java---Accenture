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

public class Circulo {
	private double raio;
	private double area;
	private double perimetro;

	public Circulo() {
	}

	public Circulo(double raio) {
		this.raio = raio;
	}

	public void calcularArea() {
		area = raio * raio * 3.14;
		JOptionPane.showMessageDialog(null, "O valor da área do círculo de raio " + raio + " é " + area + ".",
				"Área do Círculo", JOptionPane.INFORMATION_MESSAGE);
	}

	public void calcularPerimetro() {
		perimetro = 2 * 3.14 * raio;
		JOptionPane.showMessageDialog(null, "O valor do perímetro do círculo de raio " + raio + " é " + perimetro + ".",
				"Perímetro do Círculo", JOptionPane.INFORMATION_MESSAGE);
	}

	public double getRaio() {
		return raio;
	}

	public void setRaio(double raio) {
		this.raio = raio;
	}
}
