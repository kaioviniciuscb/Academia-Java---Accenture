/*
Academia Java - Accenture
M3 - Language Fundamentals - Part II
Arrays - Atividade 4 - Movimentando peão no xadrez
Autor: Kaio Vinícius Cordeiro Batista
Instituição na qual é vinculado: UEPB - Campus VII - Patos/PB
Data: 23/07/2024
*/

package sef.module3.sample;

import java.util.Scanner;

public class ChessBoard {
	private static Scanner inputInt = new Scanner(System.in);
	private static Scanner inputString = new Scanner(System.in);

	public static void main(String[] args) {
		String[][] board = {{ "R", "N", "B", "Q", "K", "B", "N", "R" },
							{ "P", "P", "P", "P", "P", "P", "P", "P" },
							{ " ", " ", " ", " ", " ", " ", " ", " " },
							{ " ", " ", " ", " ", " ", " ", " ", " " },
							{ " ", " ", " ", " ", " ", " ", " ", " " },
							{ " ", " ", " ", " ", " ", " ", " ", " " },
							{ "p", "p", "p", "p", "p", "p", "p", "p" },
							{ "r", "n", "b", "q", "k", "b", "n", "r" }};

		imprimirBoard(board);

		// Mover Cavalo
		System.out.println("");
		moverPeca(board, 7, 6, 5, 5);
		imprimirBoard(board);

		// Mover Peao
		System.out.println("");
		moverPeca(board, 6, 2, 4, 2);

		String respUser = "";
		do {
			imprimirBoard(board);
			System.out.print("Informe a posição atual do peão que você deseja movimentar:\nLinha: ");
			int linhaAtual = inputInt.nextInt();
			System.out.print("Coluna: ");
			int colunaAtual = inputInt.nextInt();
			while (!isPeao(board, linhaAtual, colunaAtual)) {
				System.out.println("A peça que você quer mover não é peão! Escolha outra peça.");
				imprimirBoard(board);
				System.out.print("Informe a posição atual do peão que você deseja movimentar:\nLinha: ");
				linhaAtual = inputInt.nextInt();
				System.out.print("Coluna: ");
				colunaAtual = inputInt.nextInt();
			}

			System.out.print("Informe a posição para onde você deseja mover o peão:\nLinha: ");
			int linhaNova = inputInt.nextInt();
			System.out.print("Coluna: ");
			int colunaNova = inputInt.nextInt();
			if (isMovimentoValido(board, linhaAtual, colunaAtual, linhaNova, colunaNova)) {
				moverPeca(board, linhaAtual, colunaAtual, linhaNova, colunaNova);
				imprimirBoard(board);
			} else {
				System.out.println("Movimento inválido! Tente outro movimento.");
			}

			System.out.println("Deseja mover mais um peão? [sim/nao]");
			respUser = inputString.nextLine();
		} while (respUser.toLowerCase().equals("sim"));

		System.out.println("\nAo final das jogadas, o board ficou assim...");
		imprimirBoard(board);
		System.out.println("Partida encerrada.");
	}

	// --------------Impressão do Tabuleiro---------------------------------------
	public static void imprimirBoard(String[][] board) {
		System.out.println("-------- CHESS --------");
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + "  ");
			}
			System.out.println("");
		}
	}

	public static boolean isPeao(String[][] board, int linhaAtual, int colunaAtual) {
		if (linhaAtual >= 0 && linhaAtual < 8 && colunaAtual >= 0 && colunaAtual < 8) {
			if (board[linhaAtual][colunaAtual].equals("p") || board[linhaAtual][colunaAtual].equals("P")) {
				return true;
			}
		}
		return false;
	}

	public static boolean isMovimentoValido(String[][] board, int linhaAtual, int colunaAtual, int linhaNova,
			int colunaNova) {
		String pecaMovida = board[linhaAtual][colunaAtual];

		if (pecaMovida.equals("p")) {
			if (linhaAtual == 6 && linhaNova == 4 && colunaAtual == colunaNova && board[linhaNova][colunaNova].equals(" ") && board[5][colunaAtual].equals(" ")) { // primeiro movimento/pular duas casas
				return true;
			} else if (linhaNova == linhaAtual - 1 && colunaAtual == colunaNova && board[linhaNova][colunaNova].equals(" ")) { // ir para casa a frente
				return true;
			} else if (linhaNova == linhaAtual - 1 && Math.abs(colunaNova - colunaAtual) == 1 && !board[linhaNova][colunaNova].equals(" ") && Character.isUpperCase(board[linhaNova][colunaNova].charAt(0))) { // capturar peça adversária
				return true;
			}
		}

		if (pecaMovida.equals("P")) {
			if (linhaAtual == 1 && linhaNova == 3 && colunaAtual == colunaNova && board[linhaNova][colunaNova].equals(" ") && board[2][colunaAtual].equals(" ")) {
				return true;
			} else if (linhaNova == linhaAtual + 1 && colunaAtual == colunaNova && board[linhaNova][colunaNova].equals(" ")) {
				return true;
			} else if (linhaNova == linhaAtual + 1 && Math.abs(colunaNova - colunaAtual) == 1 && !board[linhaNova][colunaNova].equals(" ") && Character.isLowerCase(board[linhaNova][colunaNova].charAt(0))) {
				return true;
			}
		}

		return false;
	}

	public static void moverPeca(String[][] board, int linhaAtual, int colunaAtual, int linhaNova, int colunaNova) {
		board[linhaNova][colunaNova] = board[linhaAtual][colunaAtual];
		board[linhaAtual][colunaAtual] = " ";
	}
}