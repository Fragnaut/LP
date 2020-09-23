package Gerador;

import java.util.ArrayList;
import java.util.List;
import tools.ManipulaArquivo;

/**
 *
 * @author Winicius Abilio de Britto
 */
public class GeradorControle {

    public GeradorControle() {
    }

    public GeradorControle(String classe, String classeMinusculo, String tipo, String nomeAtributo, String listaAux) {
        List<String> codigoControle = new ArrayList<>();

        codigoControle.add("package Controle;\n"
                + "\n"
                + "import Entidade." + classe
                + ";\n"
                + "import java.util.ArrayList;\n"
                + "import java.util.List;\n"
                + "import tools.ManipulaArquivo;\n"
                + "\n"
                + "/**\n"
                + " *\n"
                + " * @author Winicius Abilio de Britto\n"
                + " */\n"
                + "public class Controle" + classe + " {\n\n"
                + "    private List<" + classe + "> lista = new ArrayList<>();\n"
                + "\n"
                + "    public Controle" + classe + "() { //esse construtor é usado para adicionar alguns dados na lista e \n"
                + "\n"
                + "    }\n"
                + "\n"
                + "    public void limparLista() {\n"
                + "        lista.clear();//zera a lista\n"
                + "    }\n"
                + "\n"
                + "    public void adicionar(" + classe + " " + classeMinusculo + ") {\n"
                + "        lista.add(" + classeMinusculo + ");\n"
                + "    }\n"
                + "\n"
                + "    public List<" + classe + "> listar() {\n"
                + "        return lista;\n"
                + "    }\n"
                + "\n"
                + "    public " + classe + " buscar(" + tipo + " " + nomeAtributo + ") {\n"
                + "        for (int i = 0; i < lista.size(); i++) {\n"
                + "            if (lista.get(i).get" + nomeAtributo + "().equals(" + nomeAtributo + ")) {\n"
                + "                return lista.get(i);\n"
                + "            }\n"
                + "        }\n"
                + "        return null;\n"
                + "    }\n"
                + "    public void alterar(" + classe + " " + classeMinusculo + ", " + classe + " " + classeMinusculo + "Antigo) {\n"
                + "        lista.set(lista.indexOf(" + classeMinusculo + "Antigo), " + classeMinusculo + ");\n"
                + "    }\n"
                + "\n"
                + "    public void excluir(" + classe + " " + classeMinusculo + ") {\n"
                + "        lista.remove(" + classeMinusculo + ");\n"
                + "    }\n"
                + "\n"
                + "    public void gravarLista(String caminho) {\n"
                + "        ManipulaArquivo manipulaArquivo = new ManipulaArquivo();\n"
                + "        List<String> listaDeString = new ArrayList<>();\n"
                + "        for (" + classe + " " + classeMinusculo + " : lista) {\n"
                + "            listaDeString.add(" + classeMinusculo + ".toString());\n"
                + "        }\n"
                + "        manipulaArquivo.salvarArquivo(caminho, listaDeString);\n"
                + "    }\n"
                + "\n"
                + "    public void carregarDados(String caminho) {\n"
                + "        ManipulaArquivo manipulaArquivo = new ManipulaArquivo();\n"
                + "        if (!manipulaArquivo.existeOArquivo(caminho)) {\n"
                + "            manipulaArquivo.criarArquivoVazio(caminho);\n"
                + "        }\n"
                + "\n"
                + "        List<String> listaDeString = manipulaArquivo.abrirArquivo(caminho);\n"
                + "        //converter de CSV para " + classe + "\n"
                + "        " + classe + " " + classeMinusculo + ";\n"
                + "        for (String string : listaDeString) {\n"
                + "            String aux[] = string.split(\";\");\n"
                + "            " + classeMinusculo + " = new " + classe + "(" + listaAux + ");\n"
                + "            lista.add(" + classeMinusculo + ");\n"
                + "        }\n"
                + "    }\n"
                + "\n"
                + "}"
        );
        ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
        manipulaArquivo.salvarArquivo("src/Controle/Controle" + classe + ".java", codigoControle);

        for (int i = 0; i < codigoControle.size(); i++) {
            System.out.println(codigoControle.get(i));
        }
    }

}
