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

public class ContaCorrente {
	private String numero;
	private double saldo;
	private Date data;
	private Cliente titular;

	public ContaCorrente() {
	}

	public ContaCorrente(String numero, double saldo, Date data, Cliente titular) {
		this.numero = numero;
		this.saldo = saldo;
		this.data = data;
		this.titular = titular;
	}

	public void depositar(double valor) {
		if (valor > 0) {
			saldo += valor;
			System.out.printf("Depósito de R$%.2f realizado na conta %s!\n", valor, numero);
		} else {
			System.out.println("Não é possível depositar esse valor!");
		}
	}

	public void sacar(double valor) {
		if (valor > 0 && valor <= saldo) {
			saldo -= valor;
			System.out.printf("Saque de R$%.2f realizado na conta %s!\n", valor, numero);
		} else {
			System.out.println("Saldo insuficiente ou valor de saque inválido!");
		}
	}

	public void transferir(ContaCorrente contaDestino, double valor) {
		if (valor > 0 && valor <= saldo) {
			saldo -= valor;
			System.out.printf("Transferência de R$%.2f realizada da conta %s para a conta %s!\n", valor, numero, contaDestino.getNumero());
			contaDestino.depositar(valor);
		} else {
			System.out.println("Saldo insuficiente ou valor de transferência inválido!");
		}
	}

	public void exibirExtrato() {
		System.out.println("---------- EXTRATO DA CONTA ----------");
		System.out.println("Número da conta: " + numero);
		System.out.println("Nome do titular da conta: " + titular.getNome() + " " + titular.getSobrenome());
		System.out.println("CPF do titular da conta: " + titular.getCpf());
		System.out.printf("Saldo atual: R$%.2f\n", saldo);
		System.out.println("Data de abertura da conta: " + data);
		System.out.println("--------------------------------------");
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Cliente getTitular() {
		return titular;
	}

	public void setTitular(Cliente titular) {
		this.titular = titular;
	}
}
