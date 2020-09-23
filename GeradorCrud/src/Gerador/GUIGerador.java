package Gerador;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Winicius Abilio de Britto
 */
public class GUIGerador extends JDialog {

    Container cp;

    JPanel pn1 = new JPanel();
    JPanel pn1_1 = new JPanel();
    JPanel pn2 = new JPanel();

    JLabel lbNome = new JLabel("Nome do CRUD");
    JTextField tfNome = new JTextField(25);
    JLabel lbValor = new JLabel("Digite o atributo da seguinte maneira (tipo nome tamanhoTextField)");
    JTextField tfValor = new JTextField(10);

    JButton btGerar = new JButton("Gerar CRUD");
    JButton btAdicionar = new JButton("Adicionar");
    JButton btListar = new JButton("Listar Atributos");
    JButton btExcluir = new JButton("Excluir Atributos");

    String[] colunas = new String[]{"Tipo", "Atributo"};
    String[][] dados = new String[0][colunas.length];
    DefaultTableModel model = new DefaultTableModel(dados, colunas);
    JTable tabela = new JTable(model);

    private JScrollPane scrollTabela = new JScrollPane();

    public GUIGerador() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp = getContentPane();
        cp.setLayout(new GridLayout(4, 1));
        setTitle("Gerador de CRUD");

        cp.add(pn1);
        cp.add(pn1_1);
        cp.add(pn2);

        pn1.add(lbNome);
        pn1.add(tfNome);

        pn1_1.add(lbValor);
        pn1_1.add(tfValor);
        pn1_1.add(btAdicionar);

        pn2.add(btGerar);
        pn2.add(btListar);
        pn2.add(btExcluir);

        List<String> atributo = new ArrayList<>();

        btAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String valor = tfValor.getText();
                    atributo.add(valor);
                } catch (Exception erro) {
                    JOptionPane.showMessageDialog(null, "Digite um valor válido!", "Erro Quantidade de Atributos", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        );

        btListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] colunas = {"Tipo", "Atributo"};
                Object[][] dados = new Object[atributo.size()][colunas.length];
                String aux[];
                for (int i = 0; i < atributo.size(); i++) {
                    aux = atributo.get(i).toString().split(" ");
                    for (int j = 0; j < colunas.length; j++) {
                        dados[i][j] = aux[j];
                    }
                }
                scrollTabela.setPreferredSize(tabela.getPreferredSize());
                scrollTabela.setViewportView(tabela);

                model.setDataVector(dados, colunas);

                JDialog Lista = new JDialog();

                Lista.setTitle("Lista de animes");
                Lista.add(scrollTabela);
                Toolkit tk = Toolkit.getDefaultToolkit();
                Dimension d = tk.getScreenSize();
                Lista.setSize(d.width, d.height);
                Lista.setLocationRelativeTo(null);//centraliza na tela
                Lista.setVisible(true);
            }
        });

        btExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atributo.clear();
            }
        });

        btGerar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String classe = tfNome.getText();

                Processamento processamento = new Processamento(classe, atributo);

                String aux[] = processamento.getAux();
                String classeMinusculo = processamento.getClasseMinusculo();
                String tipo = processamento.getTipo();
                String nomeAtributo = processamento.getNomeAtributo();
                String declaracaoVariaveis = processamento.getDeclaracaoVariaveis();
                String atributoThis = processamento.getAtributoThis();
                String funcoesGetSet = processamento.getFuncoesGetSet();
                String toString = processamento.getToString();

                String listaAtributo = processamento.getListaAtributo();
                String listaAux = processamento.getListaAux();
                String listaLbTf = processamento.getListaLbTf();
                String listaColuna = processamento.getListaColuna();
                String listaPn2 = processamento.getListaPn2();
                String listaEditavelFalse = processamento.getListaEditavelFalse();
                String listaEditavelTrue = processamento.getListaEditavelTrue();
                String pkBtBuscar = processamento.getPkBtBuscar();
                String btBuscarSetText = processamento.getBtBuscarSetText();
                String btBuscarSetTextVazio = processamento.getBtBuscarSetTextVazio();
                String btSalvar = processamento.getBtSalvar();

                GeradorEntidade entidade = new GeradorEntidade(classe, atributoThis, funcoesGetSet, toString, declaracaoVariaveis, listaAtributo);
                GeradorControle controle = new GeradorControle(classe, classeMinusculo, tipo, nomeAtributo, listaAux);
                GeradorGUI gui = new GeradorGUI(classe, classeMinusculo, nomeAtributo,
                        tipo, listaLbTf, listaColuna, listaPn2,
                        listaEditavelFalse, listaEditavelTrue, pkBtBuscar, btBuscarSetText,
                        btBuscarSetTextVazio, btSalvar);

            }
        }
        );

        setSize(700, 300);
        setLocationRelativeTo(null);//centraliza na tela
        setVisible(true);
    }


}
