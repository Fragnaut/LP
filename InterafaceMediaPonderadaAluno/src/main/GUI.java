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
    JPanel pnE = new JPanel();
    JPanel pnF = new JPanel();

    JLabel lbTitulo = new JLabel("Resultado de um aluno");
    JLabel lbCodigo = new JLabel("Código do aluno");
    JLabel lbCodigoo = new JLabel("");
    JLabel lbCodigooo = new JLabel("Código do aluno");
    JLabel lbNotas = new JLabel("Notas");
    JLabel lbNotass = new JLabel("Notas");
    JLabel lbNotaa1 = new JLabel("");
    JLabel lbNotaa2 = new JLabel("");
    JLabel lbNotaa3 = new JLabel("");
    JLabel lbMedia = new JLabel("Média");
    JLabel lbResultado = new JLabel("Resultado");

    JLabel lbMediaa = new JLabel("");
    JLabel lbResultadoo = new JLabel("");

    JButton btCalcular = new JButton("Calcular");

    JTextField tfCodigo = new JTextField(15);
    JTextField tfNota1 = new JTextField(3);
    JTextField tfNota2 = new JTextField(3);
    JTextField tfNota3 = new JTextField(3);

    public GUI() {
        setTitle("Exercício 5 lista 11");

        cp = getContentPane();
        cp.setLayout(new GridLayout(6, 1));

        cp.add(pnA);
        cp.add(pnB);
        cp.add(pnC);
        cp.add(pnD);
        cp.add(pnE);
        cp.add(pnF);

        pnA.add(lbTitulo);

        pnB.add(lbCodigo);
        pnB.add(tfCodigo);
        pnB.add(lbNotas);
        pnB.add(tfNota1);
        pnB.add(tfNota2);
        pnB.add(tfNota3);

        pnC.add(btCalcular);

        pnD.add(lbCodigooo);
        pnD.add(lbCodigoo);
        pnD.add(lbNotass);
        pnD.add(lbNotaa1);
        pnD.add(lbNotaa2);
        pnD.add(lbNotaa3);

        pnE.add(lbMedia);
        pnE.add(lbMediaa);

        pnF.add(lbResultado);
        pnF.add(lbResultadoo);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(620, 480);
        setVisible(true);

        btCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int verificador = 0;
                double nota1 = 0;
                double nota2 = 0;
                double nota3 = 0;
                double[] notas = new double[3];
                try {
                    notas[0] = Double.parseDouble(tfNota1.getText().replace(",", "."));
                    notas[1] = Double.parseDouble(tfNota2.getText().replace(",", "."));
                    notas[2] = Double.parseDouble(tfNota3.getText().replace(",", "."));
                    nota1 = Double.parseDouble(tfNota1.getText().replace(",", "."));
                    nota2 = Double.parseDouble(tfNota2.getText().replace(",", "."));
                    nota3 = Double.parseDouble(tfNota3.getText().replace(",", "."));
                    for (int i = 0; i < 3; i++) {
                        if (notas[i] < 0) {
                            verificador = 1;
                            JOptionPane.showMessageDialog(null, "erro, " + notas[i] + " nota menor que 0", "Erro", JOptionPane.INFORMATION_MESSAGE);
                        }
                        if (notas[i] > 10) {
                            JOptionPane.showMessageDialog(null, "erro, " + notas[i] + " nota maior que 10", "Erro", JOptionPane.INFORMATION_MESSAGE);
                            verificador = 1;
                        }
                    }
                } catch (Exception erro) {
                    JOptionPane.showMessageDialog(null, "erro na entrada", "Erro", JOptionPane.INFORMATION_MESSAGE);
                }
                if (verificador == 0) {
                    Processamento processamento = new Processamento(notas);
                    lbMediaa.setText(Double.toString(processamento.getMedia()));
                    lbResultadoo.setText(processamento.getResultado());
                    lbCodigoo.setText("| " + tfCodigo.getText() + " | ");
                    lbNotaa1.setText("| " + Double.toString(nota1) + " | ");
                    lbNotaa2.setText(Double.toString(nota2) + " | ");
                    lbNotaa3.setText(Double.toString(nota3) + " |");
                }
            }
        }
        );
    }
}
