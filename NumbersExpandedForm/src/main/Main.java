package main;

/**
 *
 * @author Fragnaut
 */
public class Main {

    public static void main(String[] args) {
        Entrada entrada = new Entrada();
        Processamento processamento = new Processamento();
        Saida saida = new Saida();
        int num = entrada.lerNumero("Digite um numero");
        saida.imprimirString("Resposta", processamento.expandedForm(num));
    }
}
