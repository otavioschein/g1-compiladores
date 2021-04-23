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
        String tipoVariavel = retornaTipoVariavel(string);
        Boolean matchFound = string.matches("\\s*(final)?\\s*" + tipoVariavel + ".*;");
        if (matchFound) {
            System.out.printf("Linha %d: Declaração de variável do tipo %s.\n", count, tipoVariavel);
        }
    }

    public static void verificaDeclaracaoDeMetodo(String string, int count) {
        String visibilidade = retornaTipoVisibilidade(string);
        String tipoDeRetornoMetodo = retornaTipoRetornoDoMetodo(string);
        Boolean matchFound = string.matches(
                "\\s*" + visibilidade + "\\s*(static)?\\s*" + tipoDeRetornoMetodo + ".*[(].*[)]\\s*[{]"
                );
        if (matchFound) {
            System.out.printf("Linha %d: Declaração de método %s que retorna um %s.\n", count, visibilidade, tipoDeRetornoMetodo);
        } else {
            System.out.println("Match not found.");
        }
    }

    public static void verificaIf(String string, int count) {
        Boolean matchFound = string.matches("if[ (].*[) ][ {]");
        if (matchFound) {
            System.out.printf("Linha %d: Estrutura de controle condicional.\n", count);
        }
    }

    public static String retornaTipoVariavel(String string) {
        if(string.matches(".*byte.*")) {
            return "byte";
        } else if(string.matches(".*short.*")) {
            return "short";
        } else if(string.matches(".*int.*")) {
            return "int";
        } else if(string.matches(".*long.*")) {
            return "long";
        } else if(string.matches(".*float.*")) {
            return "float";
        } else if(string.matches(".*double.*")) {
            return "double";
        } else if(string.matches(".*char.*")) {
            return "char";
        } else if(string.matches(".*String.*")) {
            return "String";
        } else if (string.matches(".*Boolean.*")) {
            return "Boolean";
        }
        return null;
    }

    public static String retornaTipoVisibilidade(String string) {
        if(string.matches(".*public.*")) {
            return "public";
        } else if(string.matches(".*private.*")) {
            return "private";
        } else if(string.matches(".*protected.*")) {
            return "protected";
        }
        return null;
    }

    public static String retornaTipoRetornoDoMetodo(String string) {
        if(string.matches(".*void.*[(].*[)]\\s*[{]")) {
            return "void";
        } else if(string.matches(".*int.*[(].*[)]\\s*[{]")) {
            return "int";
        } else if(string.matches(".*long.*[(].*[)]\\s*[{]")) {
            return "long";
        } else if(string.matches(".*float.*[(].*[)]\\s*[{]")) {
            return "float";
        }  else if(string.matches(".*double.*[(].*[)]\\s*[{]")) {
            return "double";
        }  else if(string.matches(".*char.*[(].*[)]\\s*[{]")) {
            return "char";
        }  else if(string.matches(".*Boolean.*[(].*[)]\\s*[{]")) {
            return "Boolean";
        } else if(string.matches(".*String.*[(].*[)]\\s*[{]")) {
            return "String";
        }
        return null;
    }
}
