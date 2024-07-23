/*
Academia Java - Accenture
M3 - Language Fundamentals - Part II
Scanners - Atividade 2 - Correção na classe LocalizaNumero.java
Autor: Kaio Vinícius Cordeiro Batista
Instituição na qual é vinculado: UEPB - Campus VII - Patos/PB
Data: 22/07/2024
*/

package sef.module3.sample;

//Fa�a um programa para pesquisar o valor 8 no vetor dado:
//inteiro vetor[] = {1, 3, 5, 8, 9, 10}
import java.util.Scanner;

public class LocalizaNumero {
	// Corrigir este algoritmo.
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int vetor[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int numero = 0;
		int posicaoEncontrada = -1;
		boolean achou = false;

		System.out.print("Digite um número para ser buscado no vetor: ");
		numero = input.nextInt();

		for (int i = 0; i < 10; i++) {
			if (vetor[i] == numero) {
				achou = true;
				posicaoEncontrada = i;
			}
		}
		if (achou) {
			System.out.println("Achei");
			System.out.printf("Na Posi��o %d est� localizado do numero %d.", posicaoEncontrada, vetor[posicaoEncontrada]);
		} else {
			System.out.printf("Não achei!\nO número %d informado anteriormente não consta no vetor.\n", numero);
		}
	}

}
