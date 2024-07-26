/*
Academia Java - Accenture
M8 - Exceptions and Assertions - Part II
Atividade 3(1) - EstouroSaqueException e DepositoInvalidoException em ContaCorrente.java
Autor: Kaio Vinícius Cordeiro Batista
Instituição na qual é vinculado: UEPB - Campus VII - Patos/PB
Data: 25/07/2024
*/

package sef.module4.activity.erros;

public class DepositoInvalidoException extends Exception {
	public DepositoInvalidoException(String motivo) {
		super(motivo);
	}
}
