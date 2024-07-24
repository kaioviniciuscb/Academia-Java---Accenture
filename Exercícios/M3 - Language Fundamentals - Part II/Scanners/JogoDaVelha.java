/*
Academia Java - Accenture
M3 - Language Fundamentals - Part II
Arrays - Atividade 3 - Implementação do jogo da velha em Java
Autor: Kaio Vinícius Cordeiro Batista
Instituição na qual é vinculado: UEPB - Campus VII - Patos/PB
Data: 23/07/2024
*/

package sef.module3.sample;

import java.util.Scanner;

public class JogoDaVelha {

	private static Scanner inputInt = new Scanner(System.in);
	private static Scanner inputString = new Scanner(System.in);
	private static String jogadorAtual = "O";
	private static boolean jogoEmAndamento = false;

	public static void main(String[] args) {
		String[][] tabuleiro = new String[3][3];
		int linha = -1, coluna = -1, jogadas = 0;
		String resp = "";
		do {
			jogoEmAndamento = true;
			limparTabuleiro(tabuleiro);
			jogadas = 0;
			while (jogoEmAndamento) {
				imprimirTabuleiro(tabuleiro);
				System.out.println("É a vez do jogador " + jogadorAtual + ":");
				System.out.print("Escolha a linha: ");
				linha = inputInt.nextInt();
				System.out.print("Escolha a coluna: ");
				coluna = inputInt.nextInt();

				// Para o caso em que o usuário insere uma entrada inválida.
				while (linha < 0 || linha > 2 || coluna < 0 || coluna > 2 || !tabuleiro[linha][coluna].equals(" ")) {
					System.out.println("ERRO! ENTRADA INVÁLIDA!\n");
					imprimirTabuleiro(tabuleiro);
					System.out.println("É a vez do jogador " + jogadorAtual + ":");
					System.out.print("Escolha a linha: ");
					linha = inputInt.nextInt();
					System.out.print("Escolha a coluna: ");
					coluna = inputInt.nextInt();
				}

				tabuleiro[linha][coluna] = jogadorAtual;
				jogadas++;
				System.out.println("");

				if (verificarGanhador(tabuleiro)) {
					imprimirTabuleiro(tabuleiro);
					System.out.println("O Jogador " + jogadorAtual + " venceu a partida!");
					jogoEmAndamento = false;
				} else if (jogadas == 9) {
					imprimirTabuleiro(tabuleiro);
					System.out.println("Essa foi a última jogada possível e ninguém venceu, portanto houve um EMPATE!");
					jogoEmAndamento = false;
				} else {
					jogadorAtual = jogadorAtual.equals("X") ? "O" : "X";
				}
			}
			System.out.println("Jogo encerrado! Deseja jogar novamente? [sim/nao]");
			resp = inputString.nextLine();
			System.out.println("");
		} while (resp.toLowerCase().equals("sim"));
		System.out.println("Jogo encerrado! Obrigado por jogar! Até a próxima! \\o");
	}

	public static void imprimirTabuleiro(String[][] tabuleiro) {
		System.out.println("----- JOGO DA VELHA -----");
		System.out.print("\n 0   1    2\n");
		for (int posicao1 = 0; posicao1 < 3; posicao1++) {
			for (int posicao2 = 0; posicao2 < 3; posicao2++) {
				System.out.print(" " + tabuleiro[posicao1][posicao2]);
				if (posicao2 < 2) {
					System.out.print(" | ");
				}
				if (posicao2 == 2) {
					System.out.print("  " + posicao1);
				}
			}
			if (posicao1 < 2) {
				System.out.print("\n------------");
			}
			System.out.println("\n");
		}
	}

	public static boolean verificarGanhador(String[][] tabuleiro) {
		// verificar se o jogador atual completou uma linha ou coluna
		for (int i = 0; i < 3; i++) {
			if (tabuleiro[i][0].equals(jogadorAtual) && tabuleiro[i][1].equals(jogadorAtual)
					&& tabuleiro[i][2].equals(jogadorAtual)) { // verifica se a linha i está completa
				return true;
			} else if (tabuleiro[0][i].equals(jogadorAtual) && tabuleiro[1][i].equals(jogadorAtual) && tabuleiro[2][i].equals(jogadorAtual)) { // verifica se a coluna i está completa
				return true;
			}
		}
		// verificar se o jogador atual completou uma das diagonais
		if (tabuleiro[0][0].equals(jogadorAtual) && tabuleiro[1][1].equals(jogadorAtual) && tabuleiro[2][2].equals(jogadorAtual)) {
			return true;
		} else if (tabuleiro[0][2].equals(jogadorAtual) && tabuleiro[1][1].equals(jogadorAtual) && tabuleiro[2][0].equals(jogadorAtual)) {
			return true;
		}
		return false;
	}
	
	public static void limparTabuleiro(String[][] tabuleiro) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				tabuleiro[i][j] = " ";
			}
		}
	}
}