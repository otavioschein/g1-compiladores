public class MetodosDeVerificacao {

    public static void menuChamaMetodos(String string, int count) {
        verificaLinhaIgnorada(string, count);
        verificaComentario(string, count);
        verificaPrint(string, count);
        verificaDeclaracaoDeVariavel(string, count);
        verificaAtribuicaoDeValorVariavel(string, count);
        verificaDeclaracaoDeMetodo(string, count);
        verificaChamadaDeMetodo(string, count);
        verificaRetornoDeValor(string, count);
        verificaFechamentoDeBloco(string, count);
        verificaCondicao(string, count);
        verificaRepeticao(string, count);
    }

    public static void verificaLinhaIgnorada(String string, int count) {
        Boolean matchFound = string.matches("\\s*");
        if(matchFound) {
            System.out.printf("Linha %d: Linha ignorada.\n", count);
        }
    }

    public static void verificaComentario(String string, int count) {
        Boolean matchFound =  string.matches(".*//.*");
        if(matchFound) {
            System.out.printf("Linha %d: Comentário de código.\n", count);
        }

    }

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
        String visibilidade = retornaTipoVisibilidade(string);
        Boolean matchFound = string.matches("\\s*("+visibilidade+")?\\s*(final)?\\s*" + tipoVariavel + ".*;");
        if (matchFound) {
            System.out.printf("Linha %d: Declaração de variável do tipo %s.\n", count, tipoVariavel);
        }
    }

    public static void verificaAtribuicaoDeValorVariavel(String string, int count) {
        String tipoVariavel = retornaTipoVariavel(string);
        String visibilidade = retornaTipoVisibilidade(string);
        Boolean matchFound = string.matches("\\s*("+visibilidade+")?\\s*(final)?\\s*" + tipoVariavel + ".*=.*;");
        if(matchFound) {
            System.out.printf("Linha %d: Atribuição de valor para variável.\n", count);
        }
    }

    public static void verificaDeclaracaoDeMetodo(String string, int count) {
        String visibilidade = retornaTipoVisibilidade(string);
        String tipoDeRetornoMetodo = retornaTipoRetornoDoMetodo(string);
        Boolean matchFound = string.matches(
                "\\s*" + visibilidade + "\\s*(static)?\\s*" + tipoDeRetornoMetodo + ".*[(].*[) ][ {]"
                );
        if (matchFound) {
            System.out.printf("Linha %d: Declaração de método %s que retorna um %s.\n", count, visibilidade, tipoDeRetornoMetodo);
        }
    }

    public static void verificaRetornoDeValor(String string, int count) {
        Boolean matchFound = string.matches("\\s*return\\s*.*");
        if(matchFound) {
            System.out.printf("Linha %d: Comando de retorno de valor.\n", count);
        }
    }

    public static void verificaFechamentoDeBloco(String string, int count) {
        Boolean matchFound = string.matches("\\s*[}]\\s*");
        if (matchFound) {
            System.out.printf("Linha %d: Fechamento de bloco de código.\n", count);
        }
    }

    public static void verificaCondicao(String string, int count) {
        Boolean matchFound = string.matches("\\s*if[ (].*[) ][ {]");
        if (matchFound) {
            System.out.printf("Linha %d: Estrutura de controle condicional.\n", count);
        }
    }

    public static void verificaRepeticao(String string, int count) {
        if(string.matches("\\s*for[ (].*[) ][ {]")) {
            System.out.printf("Linha %d: Estrutura de repetição for.\n", count);
        } else if(string.matches("\\s*while[ (].*[) ][ {]")) {
            System.out.printf("Linha %d: Estrutura de repetição while.\n", count);
        }
    }

    public static void verificaChamadaDeMetodo(String string, int count) {
        Boolean matchFound = string.matches("\\s*.*[(].*[)];");
        if(matchFound) {
            System.out.printf("Linha %d: Chamada de método.\n", count);
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
