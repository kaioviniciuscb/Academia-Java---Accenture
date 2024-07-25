/*
Academia Java - Accenture
M4 - Classes and Objects - Part II
Atividade 1 - Conta Corrente
Autor: Kaio Vinícius Cordeiro Batista
Instituição na qual é vinculado: UEPB - Campus VII - Patos/PB
Data: 25/07/2024
*/

package sef.module4.activity;

import java.util.Date;

public class PrincipalContaCorrente {

	public static void main(String[] args) {
		Cliente c1 = new Cliente("José", "Nogueira Melo", "354.123.099-10");
		Cliente c2 = new Cliente("Maria", "Alves dos Santos", "202.112.550-98");
		ContaCorrente cc1 = new ContaCorrente("87765-1", 500, new Date(), c1);
		ContaCorrente cc2 = new ContaCorrente("75759-2", 300, new Date(), c2);

		cc1.depositar(100);
		cc1.sacar(200);
		cc1.transferir(cc2, 50);
		System.out.println("");
		cc1.exibirExtrato();
		System.out.println("");
		cc2.exibirExtrato();
		System.out.println("");

		Cliente c3 = new Cliente("Pedro Hugo", "Maia Mota", "101.444.330-22");
		Cliente c4 = new Cliente("Josefina", "Soares da Costa Neta", "555.120.397-41");
		ContaCorrente conta1 = new ContaCorrente("21054-2", 1500, new Date(), c3);
		ContaCorrente conta2 = new ContaCorrente("33350-4", 3200, new Date(), c4);

		System.out.printf("O saldo da conta %s é R$%.2f.\n", conta1.getNumero(), conta1.getSaldo());
		conta1.depositar(25);
		System.out.println("O nome do cliente da conta " + conta1.getNumero() + " é " + conta1.getTitular().getNome() + " " + conta1.getTitular().getSobrenome() + ".");
		conta1.transferir(conta2, 10);
		conta1.transferir(conta2, 2000);
	}

}
