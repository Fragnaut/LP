package main;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Fragnaut
 */
class GUI extends JFrame {

    Container cp;

    JPanel pnA = new JPanel();
    JPanel pnB = new JPanel();
    JPanel pnC = new JPanel();
    JPanel pnD = new JPanel();

    JLabel lbTitulo = new JLabel("Quantidade atual de Gaupoints");
    JLabel lbTitulo2 = new JLabel("Quantidade de Gaupoints a ser atingida");
    JLabel lbDias = new JLabel("Dias");
    JLabel lbHoras = new JLabel("Horas");
    JLabel lbMinutos = new JLabel("Minutos");
    JLabel lbSegundos = new JLabel("Segundos");
    JLabel lbDias1 = new JLabel("");
    JLabel lbHoras2 = new JLabel("");
    JLabel lbMinutos3 = new JLabel("");
    JLabel lbSegundos4 = new JLabel("");

    JButton btCalcular = new JButton("Calcular");

    JTextField qntdAtual = new JTextField(5);
    JTextField qntdMeta = new JTextField(5);

    public GUI() {
        this.setTitle("Calculador de Gaupoints");

        cp = getContentPane();
        cp.setLayout(new GridLayout(4, 1));


        cp.add(pnA);
        pnA.add(lbTitulo);
        pnA.add(qntdAtual);

        cp.add(pnB);
        pnB.add(lbTitulo2);
        pnB.add(qntdMeta);

        cp.add(pnC);
        pnC.add(btCalcular);
        
        cp.add(pnD);
        pnD.add(lbDias);
        pnD.add(lbDias1);
        pnD.add(lbHoras);
        pnD.add(lbHoras2);
        pnD.add(lbMinutos);
        pnD.add(lbMinutos3);
        pnD.add(lbSegundos);
        pnD.add(lbSegundos4);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(640, 480);
        setVisible(true);

        btCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int qntdA = 0;
                int qntdM = 0;
                int verificador = 0;
                try {
                    qntdA = Integer.parseInt(qntdAtual.getText());
                    qntdM = Integer.parseInt(qntdMeta.getText());
                    if (qntdA < 0) {
                        verificador = 1;
                        JOptionPane.showMessageDialog(null, "erro, valor de gaupoints menor que 0 ", "Erro", JOptionPane.INFORMATION_MESSAGE);
                    }
                    if (qntdM < 0) {
                        verificador = 1;
                        JOptionPane.showMessageDialog(null, "erro, valor da meta menor que 0 ", "Erro", JOptionPane.INFORMATION_MESSAGE);
                    }
                    if (qntdA >= qntdM) {
                        verificador = 1;
                        JOptionPane.showMessageDialog(null, "erro, valor de gaupoints maior que a meta ", "Erro", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception erro) {
                    JOptionPane.showMessageDialog(null, "erro na entrada", "Erro", JOptionPane.INFORMATION_MESSAGE);
                }
                if (verificador == 0) {
                    Processamento processamento = new Processamento(qntdA, qntdM);
                    lbDias1.setText(String.valueOf(processamento.getDias()));
                    lbHoras2.setText(String.valueOf(processamento.getHoras()));
                    lbMinutos3.setText(String.valueOf(processamento.getMinutos()));
                    lbSegundos4.setText(String.valueOf(processamento.getSegundos()));
                }
            }
        });
    }
}
