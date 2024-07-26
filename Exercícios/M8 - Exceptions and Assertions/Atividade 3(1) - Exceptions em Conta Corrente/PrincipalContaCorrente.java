/*
Academia Java - Accenture
M4 - Classes and Objects - Part II
Atividade 1 - Conta Corrente
Autor: Kaio Vinícius Cordeiro Batista
Instituição na qual é vinculado: UEPB - Campus VII - Patos/PB
Data: 25/07/2024

Essa classe também faz parte do seguinte exercício:
M8 - Exceptions and Assertions - Part II
Atividade 3(1) - EstouroSaqueException e DepositoInvalidoException em ContaCorrente.java
*/

package sef.module4.activity;

import java.util.Date;
import sef.module4.activity.erros.*; //Importando as exceções

public class PrincipalContaCorrente {

	public static void main(String[] args) {
		// Clientes do banco
		Cliente c1 = new Cliente("José", "Nogueira Melo", "354.123.099-10");
		Cliente c2 = new Cliente("Maria", "Alves dos Santos", "202.112.550-98");
		Cliente c3 = new Cliente("Pedro Hugo", "Maia Mota", "101.444.330-22");
		Cliente c4 = new Cliente("Josefina", "Soares da Costa Neta", "555.120.397-41");

		// Contas abertas
		ContaCorrente cc1 = new ContaCorrente("87765-1", 500, new Date(), c1);
		ContaCorrente cc2 = new ContaCorrente("75759-2", 300, new Date(), c2);
		ContaCorrente conta1 = new ContaCorrente("21054-2", 1500, new Date(), c3);
		ContaCorrente conta2 = new ContaCorrente("33350-4", 3200, new Date(), c4);

		try {
			cc1.depositar(100);
			cc1.sacar(200);
			cc1.transferir(cc2, 50);
		} catch (DepositoInvalidoException e) {
			System.out.println(e.getMessage());
		} catch (EstouroSaqueException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("");
		cc1.exibirExtrato();
		System.out.println("");
		cc2.exibirExtrato();
		System.out.println("");

		System.out.printf("O saldo da conta %s é R$%.2f.\n", conta1.getNumero(), conta1.getSaldo());
		System.out.println("O nome do cliente da conta " + conta1.getNumero() + " é " + conta1.getTitular().getNome()
				+ " " + conta1.getTitular().getSobrenome() + ".");
		try {
			conta1.depositar(25);
			conta1.transferir(conta2, 10);
			conta1.transferir(conta2, 2000);
		} catch (DepositoInvalidoException e) {
			System.out.println(e.getMessage());
		}

		// Testes do dia 25/07/2024 com a adição das exceções EstouroSaqueException e
		// DepositoInvalidoException
		System.out.println("");
		conta2.exibirExtrato();

		// Testanto lançamento de exceções do tipo DepositoInvalidoException
		try {
			conta2.depositar(90); // Depósito aceito
			conta2.depositar(0); // Depósito inválido, portanto deveria lançar exceção
		} catch (DepositoInvalidoException e) {
			System.out.println(e.getMessage());
		}

		// Testando lançamento de exceções do tipo EstouroSaqueException
		try {
			conta2.sacar(100); // Saque aceito
			conta2.sacar(5000); // Saque inválido (valor do saque > saldo), portanto deveria lançar uma exceção
		} catch (EstouroSaqueException e) {
			System.out.println(e.getMessage());
		}
	}

}
