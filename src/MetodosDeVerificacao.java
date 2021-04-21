public class MetodosDeVerificacao {

    public static void verificaPrint(String string, int count) {
        Boolean matchFound = string.matches(
                "\\s*(System.out.println)*(System.out.print)*(System.out.printf)*[ (].*[)];"
        );
        if (matchFound) {
            System.out.printf("Linha %d: Comando de print em tela.\n", count);
        }
    }

    public static void verificaDeclaracaoDeVariavel(String string, int count) {
        String variavel = "int";
        Boolean matchFound = string.matches("\\s*(final)?\\s*" + variavel + ".*;");
        if (matchFound) {
            System.out.printf("Linha %d: Declaração de variável.\n", count);
        }
    }

    public static void verificaIf(String string, int count) {
        Boolean matchFound = string.matches("if[ (].*[) ][ {]");
        if (matchFound) {
            System.out.printf("Linha %d: Estrutura de controle condicional.\n", count);
        }
    }
}
