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
                if (x % 2 == 0 || x < 0) {
                    int k = 0 / 0;
                }
                return x;
            } catch (Exception e) {
                System.out.println("Erro, digite um inteiro impar....");
                teclado = new Scanner(System.in);
            }
        }
    }
}
