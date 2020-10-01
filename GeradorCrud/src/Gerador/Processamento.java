package Gerador;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Winicius Abilio de Britto
 */
public class Processamento {

    private String aux[];
    private String tipo = "";
    private String nomeAtributo = "";
    private String tamanhoTf = "";
    private String declaracaoVariaveis = "";
    private String atributoThis = "";
    private String listaAtributo = "";
    private String funcoesGetSet = "";
    private String toString = "";
    private String listaAux = "";
    private String listaLbTf = "";
    private String classeMinusculo = "";
    private String listaColuna = "";
    private String listaPn2 = "";
    private String entradaAtributo[];
    private String listaEditavelFalse = "";
    private String listaEditavelTrue = "";
    private String pkBtBuscar = "";
    private String btBuscarSetText = "";
    private String btSalvar = "";

    private String btBuscarSetTextVazio = "";

    public Processamento(String classe, List<String> atributo) {

        classeMinusculo = classe.toLowerCase();

        for (int i = 0; i < atributo.size(); i++) {
            aux = atributo.get(i).split(" ");
            tipo = aux[0];
            nomeAtributo = aux[1];

            if (aux.length < 3) {
                tamanhoTf = "35";
            }

            declaracaoVariaveis += "    private " + tipo + " " + nomeAtributo + ";\n";

            atributoThis += "        this." + nomeAtributo + " = " + nomeAtributo + ";\n";

            listaAtributo += tipo + " " + nomeAtributo + ", ";

            toString += nomeAtributo + " + \";\" + ";

            funcoesGetSet += "    public " + tipo + " get" + nomeAtributo + "() {\n"
                    + "        return " + nomeAtributo + ";\n"
                    + "    }\n\n"
                    + "    public void set" + nomeAtributo + "(" + tipo + " " + nomeAtributo + ") {\n"
                    + "        this." + nomeAtributo + " = " + nomeAtributo + ";\n"
                    + "    }\n";

            if (tipo.equals("boolean")) {
                listaLbTf += "JCheckBox checkBox" + nomeAtributo + " = new JCheckBox(\"" + nomeAtributo + "\", false);";
            } else {
                listaLbTf += "    JLabel lb" + nomeAtributo + " = new JLabel(\"" + nomeAtributo + "\");\n"
                        + "    JTextField tf" + nomeAtributo + " = new JTextField(" + tamanhoTf + ");\n";
            }
            listaColuna += "\"" + nomeAtributo + "\", ";

            switch (tipo) {
                case "String":
                    pkBtBuscar = tipo + " " + nomeAtributo + " = tf" + nomeAtributo + ".getText();\n";
                    btBuscarSetText += "                        tf" + nomeAtributo + ".setText(" + classeMinusculo + ".get" + nomeAtributo + "());\n";
                    if (i > 0) {
                        btBuscarSetTextVazio += "                        tf" + nomeAtributo + ".setText(\"\");\n";
                    }
                    btSalvar += classeMinusculo + ".set" + nomeAtributo + "(tf" + nomeAtributo + ".getText());\n";
                    listaAux += "aux[" + i + "], ";
                    break;
                case "int":
                    pkBtBuscar = tipo + " " + nomeAtributo + " = Integer.valueOf(tf" + nomeAtributo + ".getText());\n";
                    btSalvar += classeMinusculo + ".set" + nomeAtributo + "(Integer.valueOf(tf" + nomeAtributo + ".getText()));\n";
                    btBuscarSetText += "                        tf" + nomeAtributo + ".setText(String.valueOf(" + classeMinusculo + ".get" + nomeAtributo + "()));\n";
                    if (i > 0) {
                        btBuscarSetTextVazio = "                        tf" + nomeAtributo + ".setText(\"\");\n";
                    }
                    listaAux += "Integer.valueOf(aux[" + i + "]), ";
                    break;
                case "double":
                    pkBtBuscar = tipo + " " + nomeAtributo + " = Double.valueOf(tf" + nomeAtributo + ".getText());\n";
                    btSalvar += classeMinusculo + ".set" + nomeAtributo + "(Double.valueOf(tf" + nomeAtributo + ".getText()));\n";
                    btBuscarSetText += "                        tf" + nomeAtributo + ".setText(String.valueOf(" + classeMinusculo + ".get" + nomeAtributo + "()));\n";
                    if (i > 0) {
                        btBuscarSetTextVazio += "                        tf" + nomeAtributo + ".setText(\"\");\n";
                    }
                    listaAux += "Double.valueOf(aux[" + i + "]), ";
                    break;
                case "boolean":
                    listaAux += "(aux[" + i + "].equals(\"Sim\") ? true : false), ";
                    btBuscarSetText += "                        checkBox" + nomeAtributo + ".setSelected(" + classeMinusculo + ".get" + nomeAtributo + "());\n";
                    btSalvar += classeMinusculo + ".set" + nomeAtributo + "(checkBox" + nomeAtributo + ".isSelected());\n";
                    btBuscarSetTextVazio += "                        checkBox" + nomeAtributo + ".setSelected(false);\n"
                            + "checkBox" + nomeAtributo + ".setEnabled(false);";
                    break;
            }

            if (i > 0 && tipo.equals("boolean")) {
                listaPn2 += "        pn2.add(checkBox" + nomeAtributo + ");\n";

                listaEditavelFalse += "                        checkBox" + nomeAtributo + ".setEnabled(false);\n";
                listaEditavelTrue += "                        checkBox" + nomeAtributo + ".setEnabled(true);\n";
            } else if (i > 0) {
                listaPn2 += "        pn2.add(lb" + nomeAtributo + ");\n"
                        + "        pn2.add(tf" + nomeAtributo + ");\n";

                listaEditavelFalse += "                        tf" + nomeAtributo + ".setEditable(false);\n";
                listaEditavelTrue += "                        tf" + nomeAtributo + ".setEditable(true);\n";
            } else if (i == 0) {
                listaEditavelFalse += "                        tf" + nomeAtributo + ".setEditable(true);\n";
                listaEditavelTrue += "                        tf" + nomeAtributo + ".setEditable(false);\n";
            }

            aux = atributo.get(0).split(" ");
            nomeAtributo = aux[1];
            tipo = aux[0];

            switch (tipo) {
                case "String":
                    pkBtBuscar = tipo + " " + nomeAtributo + " = tf" + nomeAtributo + ".getText();\n";
                    break;
                case "int":
                    pkBtBuscar = tipo + " " + nomeAtributo + " = Integer.valueOf(tf" + nomeAtributo + ".getText());\n";
                    break;
                case "double":
                    pkBtBuscar = tipo + " " + nomeAtributo + " = Double.valueOf(tf" + nomeAtributo + ".getText());\n";
                    break;
            }
        }

        for (int i = 0; i <= 1; i++) {//remove a virgula que sobra nas listas
            listaAtributo = listaAtributo.substring(0, listaAtributo.length() - 1);
            listaAux = listaAux.substring(0, listaAux.length() - 1);
            listaColuna = listaColuna.substring(0, listaColuna.length() - 1);
        }

        for (int i = 0; i <= 8; i++) {//para remover os 8 ultimos caracteres do return no toString
            toString = toString.substring(0, toString.length() - 1);
        }

        aux = atributo.get(0).split(" ");
        tipo = aux[0];
        nomeAtributo = aux[1];
    }

    public String[] getAux() {
        return aux;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNomeAtributo() {
        return nomeAtributo;
    }

    public String getDeclaracaoVariaveis() {
        return declaracaoVariaveis;
    }

    public String getAtributoThis() {
        return atributoThis;
    }

    public String getListaAtributo() {
        return listaAtributo;
    }

    public String getFuncoesGetSet() {
        return funcoesGetSet;
    }

    public String getToString() {
        return toString;
    }

    public String getListaAux() {
        return listaAux;
    }

    public String getClasseMinusculo() {
        return classeMinusculo;
    }

    public String getListaLbTf() {
        return listaLbTf;
    }

    public String getListaColuna() {
        return listaColuna;
    }

    public String getListaPn2() {
        return listaPn2;
    }

    public String[] getEntradaAtributo() {
        return entradaAtributo;
    }

    public String getListaEditavelFalse() {
        return listaEditavelFalse;
    }

    public String getListaEditavelTrue() {
        return listaEditavelTrue;
    }

    public String getPkBtBuscar() {
        return pkBtBuscar;
    }

    public String getBtBuscarSetText() {
        return btBuscarSetText;
    }

    public String getBtBuscarSetTextVazio() {
        return btBuscarSetTextVazio;
    }

    public String getBtSalvar() {
        return btSalvar;
    }

}
