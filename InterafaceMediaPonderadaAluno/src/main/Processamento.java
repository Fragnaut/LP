package main;

/**
 *
 * @author Winicius Abilio de Britto
 */
public class Processamento {

    private String resultado = "";
    private double aux = 0;
    private double maior = 0;
    private double menorA = 0;
    private double menorB = 0;
    private double media = 0;

    public Processamento(double[] notas) {
        for (int i = 0; i < notas.length; i++) {
            for (int j = 0; j < notas.length; j++) {
                if (notas[i] > notas[j]) {//Verifica se o elemento da posicao i eh menor que o elemento da posicao j
                    aux = notas[i];//aux recebe o elemento da posicao i
                    notas[i] = notas[j];//vetor na posicao i recebe o elemento da posicao j
                    notas[j] = aux;////vetor na posicao j recebe aux que era o elemento da posicao i
                }
            }

        }

        media = (notas[0] * 0.4) + (notas[1] * 0.3) + (notas[2] * 0.3);

        if (media > 6) {
            resultado = "Aprovado";
        } else {
            resultado = "Reprovado";
        }
    }

    public double getMedia() {
        return media;
    }

    public String getResultado() {
        return resultado;
    }

}
