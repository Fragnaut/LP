package main;

/**
 *
 * @author Fragnaut
 */
public class Processamento {
    
    private int tempo = 0;
    private int dias = 0;
    private int horas = 0;
    private int minutos = 0;
    private int segundos = 0;

    public Processamento(int qntdA, int qntdM) {
        while (qntdA < qntdM) {
            qntdA += 1;
            tempo += 600;//Tempo em Segundos
        }
        dias = tempo / 86400;
        horas = (tempo / 3600) % 24;
        minutos = (tempo / 60) % 60;
        segundos = tempo % 60;
    }

    public int getDias() {
        return dias;
    }

    public int getHoras() {
        return horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSegundos() {
        return segundos;
    }

}
