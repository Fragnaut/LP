package main;

import java.util.Scanner;

/**
 *
 * @author Fragnaut
 */
public class Entrada {

    Scanner teclado = new Scanner(System.in);

    public int lerNumero(String msg) {
        while (true) {
            try {
                System.out.print(msg + ": ");
                int x = teclado.nextInt();
                if (x < 0) {
                    int e = 0 / 0;
                }
                return x;
            } catch (Exception e) {
                System.out.println("Erro, digite um inteiro maior que zero....");
                teclado = new Scanner(System.in);
            }
        }
    }
}
