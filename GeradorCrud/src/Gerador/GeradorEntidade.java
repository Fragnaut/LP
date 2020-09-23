package Gerador;

import java.util.ArrayList;
import java.util.List;
import tools.ManipulaArquivo;

/**
 *
 * @author Winicius Abilio de Britto
 */
public class GeradorEntidade {

    public GeradorEntidade() {
    }

    public GeradorEntidade(String classe, String atributoThis, String funcoesGetSet, String toString, String declaracaoVariaveis, String listaAtributo) {
        List<String> codigoEntidade = new ArrayList<>();

        codigoEntidade.add(
                "package Entidade;\n\n"
                + "/**\n"
                + " *\n"
                + " * @author Winicius Abilio de Britto\n"
                + " */\n"
                + "public class " + classe + " {\n\n"
                + declaracaoVariaveis
                + "\n\n    public " + classe + "() {\n"
                + "    }\n\n"
                + "    public " + classe + "(" + listaAtributo + ") {\n"
                + atributoThis + "    }\n\n"
                + funcoesGetSet + "\n"
                + "    @Override\n"
                + "    public String toString() {\n"
                + "        return " + toString + ";\n"
                + "    }\n}"
        );

        ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
        manipulaArquivo.salvarArquivo("src/Entidade/" + classe + ".java", codigoEntidade);

        for (int i = 0; i < codigoEntidade.size(); i++) {
            System.out.println(codigoEntidade.get(i));
        }
    }

}
