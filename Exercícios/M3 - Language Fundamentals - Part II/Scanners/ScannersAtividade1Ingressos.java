/*
Academia Java - Accenture
M3 - Language Fundamentals - Part II
Scanners - Atividade 1 - Ingressos
Autor: Kaio Vinícius Cordeiro Batista
Instituição na qual é vinculado: UEPB - Campus VII - Patos/PB
Data: 22/07/2024
*/

package sef.module3.activity;

import java.util.Scanner;

public class ScannersAtividade1Ingressos {

	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int quantIngressosClasseA, quantIngressosClasseB, quantIngressosClasseC;
		float classeA = 50, classeB = 30, classeC = 20, rendaTotal = 0;
		System.out.println("Quantos ingressos da classe A foram vendidos?");
		quantIngressosClasseA = input.nextInt();
		System.out.println("Quantos ingressos da classe B foram vendidos?");
		quantIngressosClasseB = input.nextInt();
		System.out.println("Quantos ingressos da classe C foram vendidos?");
		quantIngressosClasseC = input.nextInt();
		rendaTotal = quantIngressosClasseA * classeA + quantIngressosClasseB * classeB + quantIngressosClasseC * classeC;
		System.out.printf("A renda total gerada pela venda dos ingressos foi de R$%.2f.\n", rendaTotal);
	}
	
}
