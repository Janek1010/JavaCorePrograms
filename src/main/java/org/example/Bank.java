package org.example;

import java.util.*;

/**
 * Bank z kilkoma kontami
 * @version 1.30 2004-08-01
 * @author Cay Horstmann
 */
public class Bank
{
    private final double[] accounts;

    /**
     * Tworzy bank.
     * @param n liczba kont
     * @param initialBalance saldo pocz�tkowe na ka�dym koncie
     */
    public Bank(int n, double initialBalance)
    {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    /**
     * Przelewa pieni�dze pomi�dzy kontami.
     * @param from konto, z kt�rego ma nast�pi� przelew
     * @param to konto, na kt�re maj� zosta� przelane �rodki
     * @param amount kwota do przelania
     */
    public void transfer(int from, int to, double amount)
    {
        if (accounts[from] < amount) return;
        System.out.print(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf(" %10.2f from %d to %d", amount, from, to);
        accounts[to] += amount;
        System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
    }

    /**
     * Zwraca sum� sald wszystkich kont.
     * @return saldo og�lne
     */
    public double getTotalBalance()
    {
        double sum = 0;

        for (double a : accounts)
            sum += a;

        return sum;
    }

    /**
     * Zwraca liczb� kont w banku.
     * @return liczba kont
     */
    public int size()
    {
        return accounts.length;
    }
}
